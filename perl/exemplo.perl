sub f { $x=3; return $x; }
sub g { local $x=1; return f(); }
print g()."\n";
