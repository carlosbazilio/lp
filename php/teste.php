<?php
	function are_all_int ( ) {
		$args = func_get_args ();
	    var_dump($args);
	    foreach ( $args as $arg )
	        if ( ! is_int ( $arg ) )
	            return false;
	    return true;
	}

	// Example:
	var_dump( are_all_int ( 4, 9 ) ); // true
	var_dump( are_all_int ( 22, 08, 'foo' ) ); // false
?>

