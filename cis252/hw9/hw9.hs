--  Zayadur Khan    04/08/17    CIS-252     Assignment 9

import Turing

--  countDGGD takes string containing 'd's and 'g's
--  and prints a unary count of the number of times
--  the string "dggd" appears within the original string

countDGGD :: Prog
countDGGD   = [
        (("scan",'d'),('d',Rght,"sawD")),
        (("scan",'g'),('g',Rght,"scan")),

        (("sawD",'d'),('d',Rght,"sawD")),
        (("sawD",'g'),('g',Rght,"sawDG")),

        (("sawDG",'d'),('d',Rght,"sawD")),
        (("sawDG",'g'),('g',Rght,"sawDGG")),

        (("sawDGG",'d'),('D',Rght,"tally")),
        (("sawDGG",'g'),('g',Rght,"scan")),

        (("tally",'d'),('d',Rght,"tally")),
        (("tally",'g'),('g',Rght,"tally")),
        (("tally",' '),('1',Lft,"backup")),
        (("tally",'1'),('1',Rght,"tally")),

        (("backup",'d'),('d',Lft,"backup")),
        (("backup",'g'),('g',Lft,"backup")),
        (("backup",'1'),('1',Lft,"backup")),
        (("backup",'D'),('d',Rght,"sawD"))
    ]

--  reverseMQ takes a string of 'm's and 'q's 
--  and reverses that string
--  i.e.    mqqmmmq --> qmmmqqm

reverseMQ :: Prog
reverseMQ   = [

        (("scan",'m'),('M',Rght,"scan")),
        (("scan",'q'),('Q',Rght,"scan")),
        (("scan",' '),(' ',Lft,"traceLft")),

        (("traceLft",'M'),('M',Rght,"placeM")),
        (("traceLft",'Q'),('Q',Rght,"placeQ")),
        (("traceLft",' '),(' ',Lft,"traceLft")),

        (("placeM",' '),('m',Lft,"trace")),

        (("placeQ",' '),('q',Lft,"trace")),
    ]