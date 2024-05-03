program Binding (input, output);
        procedure A(I: integer; procedure P);
                  procedure B;
                  begin
                       writeln(I);
                  end;
        begin (* A *)
             if I > 1 then
                 P
             else
                 A(2, B);
        end;

        procedure C; begin end;

begin (* main *)
     A(1, C);
end.