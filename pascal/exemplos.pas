program P1;
        type
            T1 = integer;
            T2 = integer;
            T3 = integer;
            T4 = integer;
            T5 = integer;
            T6 = integer;

        procedure P1(A1: T1);
        var X : real;
            procedure P2 (A2: T2);
            { ... }
                   procedure P3 (A3: T3);
                   begin
                        X := A3 + 9.2;
                   end;
            begin
                 X := 8.3;
                 {P4(5);}
                 writeln('O valor de X em P2 eh: ', X:3:1);
            end;

            procedure P4 (A4: T4);
            { ... }
                   function F1 (A5: T5): T6;
                   var X : integer;
                   begin
                        X := 20;
                        P2(15);
                        F1 := X;
                   end;
            begin
                 X := A1 + A4;
                 F1(30);
                 P2(5);
                 X := X + A4 + 11.5;
                 writeln('O valor de X em P4 eh: ', X:3:1);
            end;

        begin
             P4(A1);
        end;
begin
     writeln('Ola mundo!');
     P1(10);
end.