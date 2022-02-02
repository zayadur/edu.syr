## Combines inheritance, extensions, and applies concepts to a complex situation requiring multiple parameters to be met.
- Book.java provides a constructor for book object and calculates late fines or executes a check out.
- CirculatingBook.java inherits parameters from Book and creates a CirculatingBook object where it can be checked out or a late fee is assessed.
- Library.java is empty but the idea is to create multiple Book and CirculatingBook objects to perform check outs and late fee audits on.
- OvernightReserveBook.java performs the same functions as CirculatingBook, but the due date is overnight and late fee is calculated in hours.
- Two HourReserveBook.java does the same thing as OvernightReserveBook class, but due date is two hours.