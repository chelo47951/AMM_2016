/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function ()
{
   $("#Filtra").keyup(function()
    {  
        // Preleva il valore
        var text = $("#Filtra").val();
       
        $.ajax(
        {
            url: "filter.json",
            data:{             
              q: text
            },
            dataType: 'json',
            success : function(data, state){
                aggiornaListaOggetti(data);
            },
            error : function(data, state){
            }
        });
        
       // Funzione che viene richiamata in caso di successo
        function aggiornaListaOggetti(listaOggetti)
        {
            
           var $tbodyRows =    $('#articoli tbody tr');
           
            // Cancella la tabella ad eccezione dell'intestazione          
            $tbodyRows.remove(); 
         
            // Aggiunta oggetti
            
            
            
            var $tbl = $("#articoli");
            
            if(listaOggetti.length > 0)            
                for(var item in listaOggetti)
                {



                var row = $("<tr />");
                $tbl.append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
                row.append($("<td>" +  listaOggetti[item].objName+ "</td>"));


                var imgTd = $("<td />");
                var img = "<img src=\"" + listaOggetti[item].objUrl+"\" alt=\""+ listaOggetti[item].objDesc +"\" >";
                imgTd.html(img);
                row.append(imgTd);            

                row.append($("<td>" +  listaOggetti[item].objNumOfItems + "</td>"));
                row.append($("<td>" +  listaOggetti[item].objPrice + ".0€</td>"));

                var buyTd =  $("<td />");
                var imgShopper = "<img src=\"img/icona-carrello.png\" alt=\"carrello\">";
                var aTag = "<a href=\"acquista.html?ObjectSaleId="+  listaOggetti[item].objId + "\">" + imgShopper + "</a>";
                buyTd.html(aTag);            
                row.append(buyTd);
                }
              else
                  $tbl.append("<tr><td>Nessun elemento trovato</td></tr>");
        }
        
        
        function drawRow(o) {
            

 
    }
    
    }); 
});
