.data

	count:	.word 15
	array:	.word 1 4 7 10 25 3 5 13 17 21
	helper:	.word 1

.text

.globl main
main:
		la $a0 , array
		la $t1 , count
		lw $a1 , 0($t1)
		
		jal MergeSort        # calling MergeSort 
		
		li $v0,10            # Exit
		syscall

.globl merge
merge:
		addi $sp , $sp , -28
		sw $s1 , 24($sp)
		sw $s0 , 20($sp)
		sw $a3 , 16($sp)
		sw $a2 , 12($sp)
		sw $a1 , 8($sp)
		sw $a0 , 4($sp)
		sw $ra , 0($sp)
		
		la $s0 , helper
		
		add $t3 , $a1 , $a1
		add $t3 , $t3 , $t3    # t3 <-- 4*length[A] = n
		add $t4 , $a3 , $a3 
		add $t4 , $t4 , $t4    # t4 <-- 4*length[A] = m
		
		add $t0 , $zero , $zero    # i <-- 0
		add $t1 , $zero , $zero    # j <-- 0
		addi $t2 , $zero , -4      # k <-- -4
		
	LoopStart:
		blt $t0 , $t3 , Inside        # while i<=n or j<=m
		blt $t1 , $t4 , Inside
		j Outside
	Inside:
		addi $t2 , $t2 , 4      		  	# k <--- k+4
		add $t5 , $a0 , $t0                 # t5 is the address of A[i]
		add $t6 , $a2 , $t1                 # t6 is the address of B[j]
		add $s1 , $s0 , $t2                 # s1 is the address of C[k]
		lw $t7 , 0($t5)                     # t7 is A[i]
		lw $t8 , 0($t6)                     # t8 is B[j]
		
		blt $t4 , $t1 , InsideIf   			# if ( j > m)
		beq $t4 , $t1 , InsideIf
		blt $t3 , $t0 , Else   		# if ( i > n) 
		beq $t3 , $t0 , Else
		blt $t8 , $t7 , Else    		# if ( A[i] > B[j] )
	InsideIf:              
		sw $t7 , 0($s1)                      # c[k] <--- A[i]
		addi $t0 , $t0 , 4 
		j LoopStart
	Else:
		sw $t8 , 0($s1)                      # c[k] <--- B[j]
		addi $t1 , $t1 , 4
		j LoopStart
		
	Outside:
		add $v1 , $a1 , $a3                   # returns the first of merged array(v0) and its length(v1)
		add $v0 , $s0 , $zero
		
		lw $s1 , 24($sp)
		lw $s0 , 20($sp)
		lw $a3 , 16($sp)
		lw $a2 , 12($sp)
		lw $a1 , 8($sp)
		lw $a0 , 4($sp)
		lw $ra , 0($sp)
		addi $sp , $sp , 28
		
		jr $ra
		
.globl MergeSort
MergeSort:   # ( FirstOfArray , LengthOfArray )  returns first of sorted array and length of sorted array

		addi $sp , $sp , -36
		sw $s0 , 32($sp)
		sw $s1 , 28($sp)
		sw $s4 , 24($sp)
		sw $s5 , 20($sp)
		sw $ra , 16($sp)
		sw $a0 , 12($sp)
		sw $a1 , 8($sp)
		sw $a2 , 4($sp)
		sw $a3 , 0($sp)
		
		slti $t0 , $a1 , 2              # if ( n < 2 )
		beq $t0 , $zero , cont          # do not change anything
		add $v0 , $a0 , $zero
		add $v1 , $a1 , $zero
		jr $ra
		
	cont:
		add $s5 , $a0 , $zero         # s5 is the first of the first cut
		
		srl $s4 , $a1 , 1             # s4 is the length of the first cut
		sub $s0 , $a1 , $s4           # s0 is the length of the second cut
		
		add $t2 , $s4 , $s4
		add $t2 , $t2 , $t2           # t2 <--- 4*(LengthOfFirstCut)
		add $s1 , $s5 , $t2           # s1 <--- firstOfFirstCut + 4*LengthOfFirstCut
		                              # s1 is the first of the second array. 
		add $a0 , $s5 , $zero
		add $a1 , $s4 , $zero         # calling itself for the first part
		jal MergeSort
		
		add $a0 , $s1 , $zero         # calling itself for the second part
		add $a1 , $s0 , $zero 
		jal MergeSort
		
		 add $a0 , $s5 , $zero        # calling merge procedure
		 add $a1 , $s4 , $zero
		 add $a2 , $s1 , $zero
		 add $a3 , $s0 , $zero
		jal merge
		
		add $t0 , $s5 , 0      # t0 is the first of a
		add $t1 , $v0 , $zero      # t1 is the first of c
		add $t2 , $v1 , $v1
		add $t2 , $t2 , $t2       # t2 <--- 4*lengthOfSortedArray
		add $t3 , $t0 , $t2       # t3 is the one after end of sorted array in a
		
	CopyStart:                              # copying the sorted array into the given array
		slt $t4 , $t0 , $t3       
		beq $t4 , $zero , CopyFinished
		lw $t5 , 0($t1)
		sw $t5 , 0($t0)
		addi $t1 , $t1 , 4
		addi $t0 , $t0 , 4
		j CopyStart
	CopyFinished:
		lw $s0 , 32($sp)
		lw $s1 , 28($sp)
		lw $s4 , 24($sp)
		lw $s5 , 20($sp)
		lw $ra , 16($sp)
		lw $a0 , 12($sp)
		lw $a1 , 8($sp)
		lw $a2 , 4($sp)
		lw $a3 , 0($sp)
		addi $sp , $sp , 36
		
		jr $ra