program Fatorial;
        function fat(n: integer): integer;
        var
           i: integer;
        begin
             for i:=n-1 downto 1 do
                 n := n * i;
             fat := n;
        end;

        function fibonacci(n: integer): integer;
        var
           i: integer;
        begin
             if (n = 0) or (n = 1) then
                 fibonacci := 1
             else
                 fibonacci := fibonacci(n-2) + fibonacci(n-1);
        end;

        procedure imprimeValor (n: integer; function f(x:integer):integer);
        begin
             writeln('O valor da funcao aplicado a ', n, ' eh: ', f(n));
        end;

begin
     imprimeValor (6, fibonacci);
end.