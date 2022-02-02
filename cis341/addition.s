# Program: Add two numbers received from input
	.data 
Prompt1: .asciiz "\nPlease type in the first number:\n"
Prompt2: .asciiz "\nPlease type in the second number:\n"
Result_MSG: .asciiz "\nThe answer is:\n"

	.text

main:
	## Get first number from user, put into $t0.
	la $a0, Prompt1
        li $v0, 4
        syscall

	li $v0, 5 		# load syscall read_int into $v0.
	syscall 		# make the syscall.
	move $t0, $v0 		# move the number read into $t0.

	## Get second number from user, put into $t1.
	la $a0, Prompt2
        li $v0, 4
        syscall

	li $v0, 5 		# load syscall read_int into $v0.
	syscall 		# make the syscall.
	move $t1, $v0 		# move the number read into $t1.

	add $t2, $t0, $t1 	# compute the sum.

	## Print out message.
	la $a0, Result_MSG
        li $v0, 4
        syscall

	## Print out $t2
	move $a0, $t2 		# move the number to print into $a0.
	li $v0, 1 		# load syscall print_int into $v0.
	syscall 		# make the syscall.

	li $v0, 10 		# syscall code 10 is for exit.
	syscall 		# make the syscall.