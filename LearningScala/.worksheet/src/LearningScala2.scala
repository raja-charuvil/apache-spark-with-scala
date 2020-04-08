object LearningScala2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(141); 
  // Flow control
  
  // If / else syntax
  if (1 > 3) println("Impossible!") else println("The world makes sense.");$skip(96); 
  
  if (1 > 3) {
  	println("Impossible!")
  } else {
  	println("The world makes sense.")
  };$skip(68); 
  
  // Matching - like switch in other languages:
  val number = 3;System.out.println("""number  : Int = """ + $show(number ));$skip(146); 
  number match {
  	case 1 => println("One")
  	case 2 => println("Two")
  	case 3 => println("Three")
  	case _ => println("Something else")
 	};$skip(87); 
 	
 	// For loops
 	for (x <- 1 to 4) {
 		val squared = x * x
 		println(squared)
 	};$skip(81); 
                                                  
  // While loops
  var x = 10;System.out.println("""x  : Int = """ + $show(x ));$skip(47); 
  while (x >= 0) {
  	println(x)
  	x -= 1
  };$skip(59); 
                                                  
  x = 0;$skip(42); 
  do { println(x); x+=1 } while (x <= 10);$skip(154); val res$0 = 
                                                  
   // Expressions
   // "Returns" the final value in a block automatically
   
   {val x = 10; x + 20};System.out.println("""res0: Int = """ + $show(res$0));$skip(82); 
                                                
	 println({val x = 10; x + 20});$skip(372); 
	 
	 // EXERCISE
	 // Write some code that prints out the first 10 values of the Fibonacci sequence.
	 // This is the sequence where every number is the sum of the two numbers before it.
	 // So, the result should be 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
	 
	 // Solution - Method 1
	 def fibonacci(n: Int): Int = {
	 	if (n <= 2) 1
	 	else fibonacci(n-1) + fibonacci(n-2)
	  };System.out.println("""fibonacci: (n: Int)Int""");$skip(28); 
	  
	 println(fibonacci(9));$skip(276); 
	 
	 // Solution - Method 2 (Using tail recursion)
	 def fibonacciTail(n: Int): Int = {
	 
	 	def innerFib(i: Int, last: Int, secondLast: Int): Int = {
	 		if (i >= n) last
	 		else innerFib(i+1, last + secondLast, last)
	 	}
	 
	 	if (n <= 2) 1
	 	else innerFib(2, 1, 1)
	 };System.out.println("""fibonacciTail: (n: Int)Int""");$skip(32); 
	 
	 println(fibonacciTail(10));$skip(78); 
	 
	 // Println solution
	 for (i <- 0 to 10) {
	 	println(fibonacciTail(i))}}
}
