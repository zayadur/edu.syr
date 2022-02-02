        .text
main:
        add $sp, $sp, -4
        sw $ra, 4($sp)
        add $a0, $0, 16
        jal .alloc
        add $t0, $v0, 0
        add $a0, $0, 12
        jal .alloc
        add $t1, $v0, 0
        la $t2, QS_Init
        sw $t2, 12($t0)
        la $t2, QS_Print
        sw $t2, 8($t0)
        la $t2, QS_Sort
        sw $t2, 4($t0)
        la $t2, QS_Start
        sw $t2, 0($t0)
        add $t2, $0,4
L0:     add $t3, $0,12
        slt $t4, $t2, $t3
        bne $t4, 1, L1
        add $t3, $t1, $t2
        add $t4, $0,0
        sw $t4, 0($t3)
        add $t2, $t2, 4
        j L0
L1:     sw $t0, 0($t1)
        add $t0, $t1, 0
        lw $t1 0($t0)
        lw $t2 0($t1)
        add $t1, $0,10
        add $a0, $t0, 0
        add $a1, $t1, 0
        jalr $t2
        add $t3, $v0, 0
        add $a0, $0, $t3
        jal .print
        lw $ra, 4($sp)
        add $sp, $sp, 4
        add $v0, $0, 0
        jr $ra
QS_Start:
        add $sp, $sp, -12
        sw $ra, 4($sp)
        sw $s0, 12($sp)
        sw $s1, 8($sp)
        add $s0, $a0, 0
        add $s1, $a1, 0
        add $t0, $s0, 0
        lw $t1 0($t0)
        lw $t2 12($t1)
        add $a0, $t0, 0
        add $a1, $s1, 0
        jalr $t2
        add $t1, $v0, 0
        add $t2, $t1, 0
        add $t0, $s0, 0
        lw $t1 0($t0)
        lw $t2 8($t1)
        add $a0, $t0, 0
        jalr $t2
        add $t1, $v0, 0
        add $t2, $t1, 0
        add $t0, $0,9999
        add $a0, $0, $t0
        jal .print
        lw $t0 8($s0)
        add $t1, $0,1
        sub $t2, $t0, $t1
        add $t0, $s0, 0
        lw $t1 0($t0)
        lw $t3 4($t1)
        add $t1, $0,0
        add $a0, $t0, 0
        add $a1, $t1, 0
        add $a2, $t2, 0
        jalr $t3
        add $t4, $v0, 0
        add $t2, $t4, 0
        add $t0, $s0, 0
        lw $t1 0($t0)
        lw $t2 8($t1)
        add $a0, $t0, 0
        jalr $t2
        add $t1, $v0, 0
        add $t2, $t1, 0
        add $t0, $0,0
        add $v0, $t0, 0
        lw $s0, 12($sp)
        lw $s1, 8($sp)
        lw $ra, 4($sp)
        add $sp, $sp, 12
        jr $ra
QS_Sort:
        add $sp, $sp, -24
        sw $ra, 4($sp)
        sw $s0, 24($sp)
        sw $s1, 20($sp)
        sw $s2, 16($sp)
        sw $s3, 12($sp)
        sw $s4, 8($sp)
        add $s0, $a0, 0
        add $s1, $a1, 0
        add $s2, $a2, 0
        add $t0, $0,0
        slt $t1, $s1, $s2
        bne $t1, 1, L2
        lw $t1 4($s0)
        mul $t2, $s2, 4
        lw $t1 4($s0)
        lw $t3 0($t1)
        add $t4, $0,1
        slt $t5, $t2, $t3
        sub $t3, $t4, $t5
        bne $t3, 1, L4
        add $v0, $0, 10
        syscall
L4:     add $t3, $0,4
        add $t4, $t3, 0
        add $t3, $t2, $t4
        add $t2, $t3, 0
        add $t3, $t1, $t2
        lw $t1 0($t3)
        add $t2, $t1, 0
        sub $s3, $s1, 1
        add $t1, $s2, 0
        add $t3, $0,1
L5:     bne $t3, 1, L6
        add $t4, $0,1
L7:     bne $t4, 1, L8
        add $s3, $s3, 1
        lw $t5 4($s0)
        mul $t6, $s3, 4
        lw $t5 4($s0)
        lw $t7 0($t5)
        add $t8, $0,1
        slt $t9, $t6, $t7
        sub $t7, $t8, $t9
        bne $t7, 1, L9
        add $v0, $0, 10
        syscall
L9:     add $t7, $0,4
        add $t8, $t7, 0
        add $t7, $t6, $t8
        add $t6, $t7, 0
        add $t7, $t5, $t6
        lw $t5 0($t7)
        add $t6, $t5, 0
        add $t5, $0,1
        slt $t7, $t6, $t2
        sub $t8, $t5, $t7
        bne $t8, 1, L10
        add $t4, $0,0
        j L11
L10:    add $t4, $0,1
L11:    j L7
L8:     add $t4, $0,1
L12:    bne $t4, 1, L13
        sub $t1, $t1, 1
        lw $t5 4($s0)
        mul $t7, $t1, 4
        lw $t5 4($s0)
        lw $t8 0($t5)
        add $t9, $0,1
        slt $s4, $t7, $t8
        sub $t8, $t9, $s4
        bne $t8, 1, L14
        add $v0, $0, 10
        syscall
L14:    add $t8, $0,4
        add $t9, $t8, 0
        add $t8, $t7, $t9
        add $t7, $t8, 0
        add $t8, $t5, $t7
        lw $t5 0($t8)
        add $t6, $t5, 0
        add $t5, $0,1
        slt $t7, $t2, $t6
        sub $t6, $t5, $t7
        bne $t6, 1, L15
        add $t4, $0,0
        j L16
L15:    add $t4, $0,1
L16:    j L12
L13:    lw $t4 4($s0)
        mul $t5, $s3, 4
        lw $t4 4($s0)
        lw $t6 0($t4)
        add $t7, $0,1
        slt $t8, $t5, $t6
        sub $t6, $t7, $t8
        bne $t6, 1, L17
        add $v0, $0, 10
        syscall
L17:    add $t6, $0,4
        add $t7, $t6, 0
        add $t6, $t5, $t7
        add $t5, $t6, 0
        add $t6, $t4, $t5
        lw $t4 0($t6)
        add $t0, $t4, 0
        add $t4, $0,1
        mul $t5, $t4, 4
        add $t4, $s0, $t5
        lw $t6 0($t4)
        mul $t4, $s3, 4
        add $t7, $0,1
        mul $t5, $t7, 4
        add $t7, $s0, $t5
        lw $t6 0($t7)
        lw $t5 0($t6)
        add $t7, $0,1
        slt $t8, $t4, $t5
        sub $t5, $t7, $t8
        bne $t5, 1, L18
        add $v0, $0, 10
        syscall
L18:    add $t5, $0,4
        add $t7, $t5, 0
        add $t5, $t4, $t7
        add $t4, $t5, 0
        add $t5, $t6, $t4
        lw $t4 4($s0)
        mul $t6, $t1, 4
        lw $t4 4($s0)
        lw $t7 0($t4)
        add $t8, $0,1
        slt $t9, $t6, $t7
        sub $t7, $t8, $t9
        bne $t7, 1, L19
        add $v0, $0, 10
        syscall
L19:    add $t7, $0,4
        add $t8, $t7, 0
        add $t7, $t6, $t8
        add $t6, $t7, 0
        add $t7, $t4, $t6
        lw $t4 0($t7)
        sw $t4, 0($t5)
        add $t4, $0,1
        mul $t5, $t4, 4
        add $t4, $s0, $t5
        lw $t6 0($t4)
        mul $t4, $t1, 4
        add $t7, $0,1
        mul $t5, $t7, 4
        add $t7, $s0, $t5
        lw $t6 0($t7)
        lw $t5 0($t6)
        add $t7, $0,1
        slt $t8, $t4, $t5
        sub $t5, $t7, $t8
        bne $t5, 1, L20
        add $v0, $0, 10
        syscall
L20:    add $t5, $0,4
        add $t7, $t5, 0
        add $t5, $t4, $t7
        add $t4, $t5, 0
        add $t5, $t6, $t4
        sw $t0, 0($t5)
        add $t4, $0,1
        add $t5, $s3, $t4
        slt $t4, $t1, $t5
        bne $t4, 1, L21
        add $t3, $0,0
        j L22
L21:    add $t3, $0,1
L22:    j L5
L6:     add $t2, $0,1
        mul $t3, $t2, 4
        add $t2, $s0, $t3
        lw $t4 0($t2)
        mul $t2, $t1, 4
        add $t1, $0,1
        mul $t3, $t1, 4
        add $t1, $s0, $t3
        lw $t4 0($t1)
        lw $t1 0($t4)
        add $t3, $0,1
        slt $t5, $t2, $t1
        sub $t1, $t3, $t5
        bne $t1, 1, L23
        add $v0, $0, 10
        syscall
L23:    add $t1, $0,4
        add $t3, $t1, 0
        add $t1, $t2, $t3
        add $t2, $t1, 0
        add $t1, $t4, $t2
        lw $t2 4($s0)
        mul $t3, $s3, 4
        lw $t2 4($s0)
        lw $t4 0($t2)
        add $t5, $0,1
        slt $t6, $t3, $t4
        sub $t4, $t5, $t6
        bne $t4, 1, L24
        add $v0, $0, 10
        syscall
L24:    add $t4, $0,4
        add $t5, $t4, 0
        add $t4, $t3, $t5
        add $t3, $t4, 0
        add $t4, $t2, $t3
        lw $t2 0($t4)
        sw $t2, 0($t1)
        add $t1, $0,1
        mul $t2, $t1, 4
        add $t1, $s0, $t2
        lw $t3 0($t1)
        mul $t1, $s3, 4
        add $t4, $0,1
        mul $t2, $t4, 4
        add $t4, $s0, $t2
        lw $t3 0($t4)
        lw $t2 0($t3)
        add $t4, $0,1
        slt $t5, $t1, $t2
        sub $t2, $t4, $t5
        bne $t2, 1, L25
        add $v0, $0, 10
        syscall
L25:    add $t2, $0,4
        add $t4, $t2, 0
        add $t2, $t1, $t4
        add $t1, $t2, 0
        add $t2, $t3, $t1
        lw $t1 4($s0)
        mul $t3, $s2, 4
        lw $t1 4($s0)
        lw $t4 0($t1)
        add $t5, $0,1
        slt $t6, $t3, $t4
        sub $t4, $t5, $t6
        bne $t4, 1, L26
        add $v0, $0, 10
        syscall
L26:    add $t4, $0,4
        add $t5, $t4, 0
        add $t4, $t3, $t5
        add $t3, $t4, 0
        add $t4, $t1, $t3
        lw $t1 0($t4)
        sw $t1, 0($t2)
        add $t1, $0,1
        mul $t2, $t1, 4
        add $t1, $s0, $t2
        lw $t3 0($t1)
        mul $t1, $s2, 4
        add $t4, $0,1
        mul $t2, $t4, 4
        add $t4, $s0, $t2
        lw $t3 0($t4)
        lw $t2 0($t3)
        add $t4, $0,1
        slt $t5, $t1, $t2
        sub $t2, $t4, $t5
        bne $t2, 1, L27
        add $v0, $0, 10
        syscall
L27:    add $t2, $0,4
        add $t4, $t2, 0
        add $t2, $t1, $t4
        add $t1, $t2, 0
        add $t2, $t3, $t1
        sw $t0, 0($t2)
        add $t0, $s0, 0
        lw $t1 0($t0)
        lw $t2 4($t1)
        add $t1, $0,1
        sub $t3, $s3, $t1
        add $a0, $t0, 0
        add $a1, $s1, 0
        add $a2, $t3, 0
        jalr $t2
        add $t1, $v0, 0
        add $t0, $s0, 0
        lw $t1 0($t0)
        lw $t2 4($t1)
        add $t1, $0,1
        add $t3, $s3, $t1
        add $a0, $t0, 0
        add $a1, $t3, 0
        add $a2, $s2, 0
        jalr $t2
        add $t1, $v0, 0
        j L3
L2:
L3:     add $t0, $0,0
        add $v0, $t0, 0
        lw $s0, 24($sp)
        lw $s1, 20($sp)
        lw $s2, 16($sp)
        lw $s3, 12($sp)
        lw $s4, 8($sp)
        lw $ra, 4($sp)
        add $sp, $sp, 24
        jr $ra
QS_Print:
        add $sp, $sp, -8
        sw $ra, 4($sp)
        sw $s0, 8($sp)
        add $s0, $a0, 0
        add $t0, $0,0
L28:    lw $t1 8($s0)
        slt $t2, $t0, $t1
        bne $t2, 1, L29
        lw $t1 4($s0)
        mul $t2, $t0, 4
        lw $t1 4($s0)
        lw $t3 0($t1)
        add $t4, $0,1
        slt $t5, $t2, $t3
        sub $t3, $t4, $t5
        bne $t3, 1, L30
        add $v0, $0, 10
        syscall
L30:    add $t3, $0,4
        add $t4, $t3, 0
        add $t3, $t2, $t4
        add $t2, $t3, 0
        add $t3, $t1, $t2
        lw $t1 0($t3)
        add $a0, $0, $t1
        jal .print
        add $t0, $t0, 1
        j L28
L29:    add $t0, $0,0
        add $v0, $t0, 0
        lw $s0, 8($sp)
        lw $ra, 4($sp)
        add $sp, $sp, 8
        jr $ra
QS_Init:
        add $sp, $sp, -12
        sw $ra, 4($sp)
        sw $s0, 12($sp)
        sw $s1, 8($sp)
        add $s0, $a0, 0
        add $s1, $a1, 0
        sw $s1, 8($s0)
        add $t0, $s1, 1
        add $t1, $0,4
        mul $t2, $t0, $t1
        add $a0, $0, $t2
        jal .alloc
        add $t0, $v0, 0
        add $t1, $0,4
L31:    add $t2, $0,1
        add $t3, $s1, $t2
        add $t2, $0,4
        add $t4, $t2, 0
        mul $t2, $t3, $t4
        slt $t3, $t1, $t2
        bne $t3, 1, L32
        add $t2, $t0, $t1
        add $t3, $0,0
        sw $t3, 0($t2)
        add $t1, $t1, 4
        j L31
L32:    add $t1, $0,4
        mul $t2, $s1, $t1
        sw $t2, 0($t0)
        sw $t0, 4($s0)
        add $t0, $0,1
        mul $t1, $t0, 4
        add $t0, $s0, $t1
        lw $t2 0($t0)
        add $t0, $0,0
        mul $t3, $t0, 4
        add $t0, $0,1
        mul $t1, $t0, 4
        add $t0, $s0, $t1
        lw $t2 0($t0)
        lw $t0 0($t2)
        add $t1, $0,1
        slt $t4, $t3, $t0
        sub $t0, $t1, $t4
        bne $t0, 1, L33
        add $v0, $0, 10
        syscall
L33:    add $t0, $0,4
        add $t1, $t0, 0
        add $t0, $t3, $t1
        add $t1, $t0, 0
        add $t0, $t2, $t1
        add $t1, $0,20
        sw $t1, 0($t0)
        add $t0, $0,1
        mul $t1, $t0, 4
        add $t0, $s0, $t1
        lw $t2 0($t0)
        add $t0, $0,1
        mul $t3, $t0, 4
        add $t0, $0,1
        mul $t1, $t0, 4
        add $t0, $s0, $t1
        lw $t2 0($t0)
        lw $t0 0($t2)
        add $t1, $0,1
        slt $t4, $t3, $t0
        sub $t0, $t1, $t4
        bne $t0, 1, L34
        add $v0, $0, 10
        syscall
L34:    add $t0, $0,4
        add $t1, $t0, 0
        add $t0, $t3, $t1
        add $t1, $t0, 0
        add $t0, $t2, $t1
        add $t1, $0,7
        sw $t1, 0($t0)
        add $t0, $0,1
        mul $t1, $t0, 4
        add $t0, $s0, $t1
        lw $t2 0($t0)
        add $t0, $0,2
        mul $t3, $t0, 4
        add $t0, $0,1
        mul $t1, $t0, 4
        add $t0, $s0, $t1
        lw $t2 0($t0)
        lw $t0 0($t2)
        add $t1, $0,1
        slt $t4, $t3, $t0
        sub $t0, $t1, $t4
        bne $t0, 1, L35
        add $v0, $0, 10
        syscall
L35:    add $t0, $0,4
        add $t1, $t0, 0
        add $t0, $t3, $t1
        add $t1, $t0, 0
        add $t0, $t2, $t1
        add $t1, $0,12
        sw $t1, 0($t0)
        add $t0, $0,1
        mul $t1, $t0, 4
        add $t0, $s0, $t1
        lw $t2 0($t0)
        add $t0, $0,3
        mul $t3, $t0, 4
        add $t0, $0,1
        mul $t1, $t0, 4
        add $t0, $s0, $t1
        lw $t2 0($t0)
        lw $t0 0($t2)
        add $t1, $0,1
        slt $t4, $t3, $t0
        sub $t0, $t1, $t4
        bne $t0, 1, L36
        add $v0, $0, 10
        syscall
L36:    add $t0, $0,4
        add $t1, $t0, 0
        add $t0, $t3, $t1
        add $t1, $t0, 0
        add $t0, $t2, $t1
        add $t1, $0,18
        sw $t1, 0($t0)
        add $t0, $0,1
        mul $t1, $t0, 4
        add $t0, $s0, $t1
        lw $t2 0($t0)
        add $t0, $0,4
        mul $t3, $t0, 4
        add $t0, $0,1
        mul $t1, $t0, 4
        add $t0, $s0, $t1
        lw $t2 0($t0)
        lw $t0 0($t2)
        add $t1, $0,1
        slt $t4, $t3, $t0
        sub $t0, $t1, $t4
        bne $t0, 1, L37
        add $v0, $0, 10
        syscall
L37:    add $t0, $0,4
        add $t1, $t0, 0
        add $t0, $t3, $t1
        add $t1, $t0, 0
        add $t0, $t2, $t1
        add $t1, $0,2
        sw $t1, 0($t0)
        add $t0, $0,1
        mul $t1, $t0, 4
        add $t0, $s0, $t1
        lw $t2 0($t0)
        add $t0, $0,5
        mul $t3, $t0, 4
        add $t0, $0,1
        mul $t1, $t0, 4
        add $t0, $s0, $t1
        lw $t2 0($t0)
        lw $t0 0($t2)
        add $t1, $0,1
        slt $t4, $t3, $t0
        sub $t0, $t1, $t4
        bne $t0, 1, L38
        add $v0, $0, 10
        syscall
L38:    add $t0, $0,4
        add $t1, $t0, 0
        add $t0, $t3, $t1
        add $t1, $t0, 0
        add $t0, $t2, $t1
        add $t1, $0,11
        sw $t1, 0($t0)
        add $t0, $0,1
        mul $t1, $t0, 4
        add $t0, $s0, $t1
        lw $t2 0($t0)
        add $t0, $0,6
        mul $t3, $t0, 4
        add $t0, $0,1
        mul $t1, $t0, 4
        add $t0, $s0, $t1
        lw $t2 0($t0)
        lw $t0 0($t2)
        add $t1, $0,1
        slt $t4, $t3, $t0
        sub $t0, $t1, $t4
        bne $t0, 1, L39
        add $v0, $0, 10
        syscall
L39:    add $t0, $0,4
        add $t1, $t0, 0
        add $t0, $t3, $t1
        add $t1, $t0, 0
        add $t0, $t2, $t1
        add $t1, $0,6
        sw $t1, 0($t0)
        add $t0, $0,1
        mul $t1, $t0, 4
        add $t0, $s0, $t1
        lw $t2 0($t0)
        add $t0, $0,7
        mul $t3, $t0, 4
        add $t0, $0,1
        mul $t1, $t0, 4
        add $t0, $s0, $t1
        lw $t2 0($t0)
        lw $t0 0($t2)
        add $t1, $0,1
        slt $t4, $t3, $t0
        sub $t0, $t1, $t4
        bne $t0, 1, L40
        add $v0, $0, 10
        syscall
L40:    add $t0, $0,4
        add $t1, $t0, 0
        add $t0, $t3, $t1
        add $t1, $t0, 0
        add $t0, $t2, $t1
        add $t1, $0,9
        sw $t1, 0($t0)
        add $t0, $0,1
        mul $t1, $t0, 4
        add $t0, $s0, $t1
        lw $t2 0($t0)
        add $t0, $0,8
        mul $t3, $t0, 4
        add $t0, $0,1
        mul $t1, $t0, 4
        add $t0, $s0, $t1
        lw $t2 0($t0)
        lw $t0 0($t2)
        add $t1, $0,1
        slt $t4, $t3, $t0
        sub $t0, $t1, $t4
        bne $t0, 1, L41
        add $v0, $0, 10
        syscall
L41:    add $t0, $0,4
        add $t1, $t0, 0
        add $t0, $t3, $t1
        add $t1, $t0, 0
        add $t0, $t2, $t1
        add $t1, $0,19
        sw $t1, 0($t0)
        add $t0, $0,1
        mul $t1, $t0, 4
        add $t0, $s0, $t1
        lw $t2 0($t0)
        add $t0, $0,9
        mul $t3, $t0, 4
        add $t0, $0,1
        mul $t1, $t0, 4
        add $t0, $s0, $t1
        lw $t2 0($t0)
        lw $t0 0($t2)
        add $t1, $0,1
        slt $t4, $t3, $t0
        sub $t0, $t1, $t4
        bne $t0, 1, L42
        add $v0, $0, 10
        syscall
L42:    add $t0, $0,4
        add $t1, $t0, 0
        add $t0, $t3, $t1
        add $t1, $t0, 0
        add $t0, $t2, $t1
        add $t1, $0,5
        sw $t1, 0($t0)
        add $t0, $0,0
        add $v0, $t0, 0
        lw $s0, 12($sp)
        lw $s1, 8($sp)
        lw $ra, 4($sp)
        add $sp, $sp, 12
        jr $ra
.alloc:
        add $v0, $0, 9
        syscall
        jr $ra
.print:
        add $v0, $0, 1
        syscall
        add $a0, $0, 10
        add $v0, $0, 11
        syscall
        jr $ra