window.onload = function(){
                var tlacitko = document.getElementById("tlacitko");
                var a = document.getElementById("cislo1");
                var b = document.getElementById("cislo2");

                function secti(){
                    alert(parseInt(a.value)+parseInt(b.value));
                }
                
                tlacitko.onclick = secti;
            };