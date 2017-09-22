var dataHist = empresas.reduce(function (acc, emp) {
            grupo = acc.filter(function (item) {
                return emp.indiceAderencia >= item.grupo
                    && emp.indiceAderencia < (item.grupo + 10);
            });

            if(grupo && grupo.length > 0) {
                grupo[0].value++;
            }

            return acc;

        }, [0,10,20,30,40,50,60,70,80,90].map(function(range) {
            return {
                label : "[" + range + ";" + (range + 10) + (range === 90? "]" : ")"),
                grupo: range,
                value : 0
            };

        })).map(function (item) {
            item.value = (new String(item.value / empresas.length)).substr(0, 4);
            return item;
        });