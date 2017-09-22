package palindrome

fun isPalindrome(s: String): Boolean {
    // Write your solution here
    var posicao = 0
    if (s.isBlank())
    	return true
    else {
        while (posicao <= ((s.count() - 1) / 2)) {
        	if (s.elementAt(posicao) != s.elementAt(s.count() - 1 - posicao))
            	return false
            posicao++
        }
    }
    return true;
}

