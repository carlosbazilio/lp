trait Ord {
    def < (that: Any): Boolean
    def <=(that: Any): Boolean = (this < that) || (this == that)
    def > (that: Any): Boolean = !(this <= that)
    def >=(that: Any): Boolean = !(this < that)
}

class Date(d: Int, m: Int, y: Int) extends Ord {
    def year = y
    def month = m
    def day = d
    override def toString(): String = year + "-" + month + "-" + day
    
    def <(that: Any): Boolean = {
    	if (!that.isInstanceOf[Date])
    		sys.error("cannot compare " + that + " and a Date")
    	val o = that.asInstanceOf[Date]
    	(year < o.year) || (year == o.year && (month < o.month ||
    		(month == o.month && day < o.day)))
    }
    
    // Necessario para o uso do ==
    override def equals(that: Any): Boolean =
    	that.isInstanceOf[Date] && {
    		val o = that.asInstanceOf[Date]
    		o.day == day && o.month == month && o.year == year
    	}
}

println(new Date(12, 11, 2012) < new Date(13, 11, 2012))

