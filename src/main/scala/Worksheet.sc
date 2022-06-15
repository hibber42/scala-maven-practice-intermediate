val data = Array("hello", "how", "are", "you")

// method
def exitsInArrayMethod(word: String) = data.contains(word)

// function
val existsInArrayFunction = (word: String) => data.contains(word)

// conversion
val existsConvertedToFunction = exitsInArrayMethod _

println(exitsInArrayMethod("megha"))
println(existsConvertedToFunction("hello"))
println(existsConvertedToFunction("you"))

// cons operator
"red" :: "black" :: "blue" :: Nil
1 :: 2 :: 3 :: "" :: Nil // type is inferred as Any





