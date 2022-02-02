# a C conditional

if(i < n) { A[i] = 0; }

# MIPS

lw		$t0, 0($gp)		    # fetch i
lw      $t1, 4($gp)         # fetch n
slt     $t1, $t0, $t1       # set $t1 to 1 if $t0 < $t1, otherwise 0
beq     $t1, $zero, skip    # branch if result of slt is 0 (!(i<n))
sll     $t0, $t0, 2         # i as byte offset
add		$t0, $t0, $gp		# A[i] - 28
sw		$zero, 28($t0)		# A[i] = 0
skip:

# another C conditional

A[i] = A[i/2] + 1

# MIPS implementation

lw      $t0, 0($gp)         # fetch i
sll     $t0, $t0, 2         # i as byte offset
add     $t0, $t0, $gp       # A[i] - 28