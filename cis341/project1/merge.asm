#   Zayadur Khan    03/23/17    CIS-341

.data

    list:   .space 40           # reserve 40 bytes for 10 ints
	length:	.word 10
	array:	.word 1 4 7 10 25 3 5 13 17 21
	helper:	.word 1

.text

main:
    la $a0, array               # a0 is initial array address
    la $t1, length              # t1 is value of length
    lw $a1, 0($t1)              # load first word in array
    
    jal merge                   # run merge process
    
    li $v0, 10                   # exit program
    syscall

merge:
    addi $sp, $sp, -28          # use stack pointer method, adjust stack pointer
    sw $s1, 24($sp)             # bind registers to respective stack pointers
    sw $s0, 20($sp)
    sw $a3, 16($sp)             # last value in array
    sw $a2, 12($sp)
    sw $a1, 8($sp)              
    sw $a0, 4($sp)              # initial value in array
    sw $ra, 0($sp)              # return address
    
    la $s0, helper
    
    add $t3, $a1, $a1
    add $t3, $t3, $t3           # t3 is mid
    add $t4, $a3, $a3 
    add $t4, $t4, $t4           # t4 is high
    
    add $t0, $zero, $zero       # i = 0
    add $t1, $zero, $zero       # j = 0
    addi $t2, $zero, -4         # k = -4
    
    Loop:
        blt $t0, $t3, Inside    # while i <= n && j <= m
        blt $t1, $t4, Inside
        j Outside

    Inside:
        addi $t2, $t2, 4        # k += 4
        add $t5, $a0, $t0       # t5 is the address of a[i]
        add $t6, $a2, $t1       # t6 is the address of b[j]
        add $s1, $s0, $t2       # s1 is the address of c[k]
        lw $t7, 0($t5)          # t7 is a[i]
        lw $t8, 0($t6)          # t8 is b[j]
        
        blt $t4, $t1, If        # if (j > m)
        beq $t4, $t1, If
        blt $t3, $t0, Else      # if (i > n) 
        beq $t3, $t0, Else
        blt $t8, $t7, Else    	# if (a[i] > b[j])

    If:              
        sw $t7, 0($s1)          # c[k] = a[i]
        addi $t0, $t0, 4 
        j Loop

    Else:
        sw $t8, 0($s1)          # c[k] = b[j]
        addi $t1, $t1, 4
        j Loop

    Outside:
        add $v1, $a1, $a3
        add $v0, $s0, $zero
    
    lw $s1, 24($sp)
    lw $s0, 20($sp)
    lw $a3, 16($sp)
    lw $a2, 12($sp)
    lw $a1, 8($sp)
    lw $a0, 4($sp)
    lw $ra, 0($sp)
    addi $sp, $sp, 28
    
    jr $ra