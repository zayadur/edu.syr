.data

    array1:	.word 1 4 7 10 25
    array2: .word 3 5 13 17 21

.text

	la	$a0, info		# Load the start address of the array
	lw	$t0, length		# Load the array length

# Merge two sorted arrays into one

# @param $a0 First address of first array
# @param $a1 First address of second array
# @param $a2 Last address of second array

merge:
	addi	$sp, $sp, -16		# Adjust the stack pointer
	sw	$ra, 0($sp)				# Store the return address on the stack
	sw	$a0, 4($sp)				# Store the start address on the stack
	sw	$a1, 8($sp)				# Store the midpoint address on the stack
	sw	$a2, 12($sp)			# Store the end address on the stack
	
	move	$s0, $a0		# Create a working copy of the first half address
	move	$s1, $a1		# Create a working copy of the second half address
	
loop:

	lw	$t0, 0($s0)		# Load the first half position pointer
	lw	$t1, 0($s1)		# Load the second half position pointer
	lw	$t0, 0($t0)		# Load the first half position value
	lw	$t1, 0($t1)		# Load the second half position value
	
	bgt	$t1, $t0, noshift	# If the lower value is already first, don't shift
	
	move	$a0, $s1		# Load the argument for the element to move
	move	$a1, $s0		# Load the argument for the address to move it to
	jal	shift			# Shift the element to the new position 
	
	addi	$s1, $s1, 4		# Increment the second half index
noshift:
	addi	$s0, $s0, 4		# Increment the first half index
	
	lw	$a2, 12($sp)		# Reload the end address
	bge	$s0, $a2, loopend	# End the loop when both halves are empty
	bge	$s1, $a2, loopend	# End the loop when both halves are empty
	b	loop
	
loopend:
	
	lw	$ra, 0($sp)		# Load the return address
	addi	$sp, $sp, 16		# Adjust the stack pointer
	jr 	$ra			# Return