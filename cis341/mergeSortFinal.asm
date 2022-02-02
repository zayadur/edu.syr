#############################################
#   Zayadur Khan    CIS-341     03/26/17    #
#   Project 2   mergeSort implementation    #
#############################################
    
    .data
    a1:	.word 56, 3, 46, 47, 34, 12, 1, 5, 10, 8, 33, 25, 29, 31, 50, 43
    c: .word 0:20
    prompt: .asciiz "Order current array? [1:yes | 0:no]: "
    result: .asciiz "\n\tResult = "
    seperator: .asciiz ","
    
    .text

main:
	la $a0, prompt  # load prompt, wait for user input
    li $v0, 4
    syscall
    
	li $v0, 5   # read int
	syscall                             
	move $t0, $v0

    bne $t0, $zero, ec

q1:
	la $s2, a1      # load a1
	addi $s0, 10
	j call          # call mergeSort

ec:
    la $s2, a1
    addi $s0, 10
    j end

call:
	move $a0, $s2			# a[]
	move $a1, $zero			# low
	addi $a2, $s0, -1		# high

	jal mergeSort
	
end:
	move $t0, $zero
	move $t1, $s2   # head of array
	
    la $a0, result  # print resulting array
    li $v0, 4
    syscall

print:
	beq $t0, $s0, exit  # if not equal, exit
	lw $t2, 0($t1)
	move $a0, $t2
	li $v0, 1           # system call for print_int
	syscall
	
    la $a0, seperator			
    li $v0, 4   # print seperator (comma)
    syscall	
	
    addi $t0, $t0, 1
	addi $t1, $t1, 4
	
    j print

exit:
	li	$v0, 10		
	syscall
		
mergeSort:
	addi $sp, $sp, -20
	sw $ra, 0($sp)
	sw $a0, 4($sp)
	sw $a1, 8($sp)
	sw $a2, 12($sp)
	slt $t0, $a1, $a2		        # if low >= high
	beq $t0, $zero, endMergeSort
	
	add $t0, $a1, $a2		# mid
	srl $a3, $t0, 1			
	
    sw $a3, 16($sp)
	
	lw $a0, 4($sp)			# a[]
	lw $a1, 8($sp)			# low
	lw $a2, 16($sp)			# mid
	jal mergeSort
	
	lw $a0, 4($sp)			# a[]
	
    lw $a1, 16($sp)			
	addi $a1, 1             # mid++
	
    lw $a2, 12($sp)			# high
	jal mergeSort
	
	lw $a0, 4($sp)
	lw $a1, 8($sp)
	lw $a2, 12($sp)
	lw $a3, 16($sp)
	jal merge
	
endMergeSort:
	lw $ra, 0($sp)
	lw $a0, 4($sp)
	lw $a1, 8($sp)
	lw $a2, 12($sp)
	addi $sp, $sp, 20
	jr $ra                  # jump back to return address register
	
	
merge:
	addi $sp, $sp, -20
	sw $ra, 0($sp)          # return address
	sw $a0, 4($sp)			# a[]
	sw $a1, 8($sp)			# low
	sw $a2, 12($sp)			# high
	sw $a3, 16($sp)			# mid
	lw $t1, 8($sp)			# i 
	lw $t2, 8($sp)			# k 
	
    lw $t3, 16($sp)			# j 
	addi $t3, $t3, 1
	
    la $s3,	c			    # c[]
    
thisWhile:
	slt $t0, $a3, $t1		    # i <= mid
	bne $t0, $zero, thatWhile
	slt $t0, $a2, $t3           # j <= high
	bne $t0, $zero, thatWhile

thatWhile:
	slt $t0, $a3, $t1		    # i <= mid
	bne $t0, $zero, otherWhile  # if no match, jump to otherWhile
	
    sll $t4, $t1, 2			# a[i]
	add $t4, $t4, $a0		
	lw $t4, 0($t4)
	
    sll $t6, $t2, 2			# c[k] = a[i]
	add $t6, $t6, $s3		
	sw $t4, 0($t6)
	
    addi $t2, $t2, 1		# k++
	addi $t1, $t1, 1		# i++
	
    j thatWhile

otherWhile:	
	slt $t0, $a2, $t3		# j <= high
	bne $t0, $zero, for     # if no match, jump to for
	
    sll $t5, $t3, 2			# $t5 = a[j]
	add $t5, $t5, $a0		
	lw $t5, 0($t5)
	
    sll $t6, $t2, 2			# c[k] = a[j]
	add $t6, $t6, $s3		
	sw $t5, 0($t6)
	
    addi $t2, $t2, 1		# k++
	addi $t3, $t3, 1		# j++
	
    j otherWhile

if:
	sll $t4, $t1, 2			# a[i]
	add $t4, $t4, $a0		
	lw $t4, 0($t4)
	
    sll $t5, $t3, 2			# a[j]
	add $t5, $t5, $a0		
	lw $t5, 0($t5)
	
    slt $t0, $t4, $t5		# a[i] < a[j]
	beq $t0, $zero, else    # if no match, jump to for
	
    sll $t6, $t2, 2			# c[k] = a[i]
	add $t6, $t6, $s3		
	sw $t4, 0($t6)
	
    addi $t2, $t2, 1		# k++
	addi $t1, $t1, 1		# i++
	
    j thisWhile
else:
	sll $t6, $t2, 2			# c[k] = a[j]
	add $t6, $t6, $s3		
	sw $t5, 0($t6)
	
    addi $t2, $t2, 1		# k++
	addi $t3, $t3, 1		# j++
	
    j thisWhile

for:
	lw $t1, 8($sp)			    # $t1 = i 
loop:
	slt $t0, $t1, $t2		    # i < k
	beq $t0, $zero, endMerge    # if no match, jump to endMerge
	
    sll $t4, $t1, 2		# i * 4
	add $t5, $t4, $s3	# c[] + i
	add $t6, $t4, $a0	# a[] + i	
	lw $t5, 0($t5)		# c[i]					
	sw $t5, 0($t6)		# a[i] = c[i]	
	
    addi $t1,$t1,1		# i++

	j loop

endMerge:
	lw $ra, 0($sp)
	lw $a0, 4($sp)
	lw $a1, 8($sp)
	lw $a2, 12($sp)
	lw $a3, 16($sp)
	addi $sp, $sp, 20
	jr $ra