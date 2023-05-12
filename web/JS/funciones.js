$(document).ready(function(){
     $("tr #btnDelete").click(function(){
         var idb=$(this).parent().find("#idb").val();
         
         eliminar(idb);
         
     });
     function eliminar(idb){
         var url="Controlador?accion=Delete";
         $.ajax({
             type: 'POST',
             url: url,
             data: "idb="+idb,
             success: function (data , textStatus, jqXHR){
                 alert("Registro Eliminado!");
             }
         });
     }
     
     $("tr #Cantidad").click(function (){
         var idb=$(this).parent().find("#idlib").val();
         var cantidad=$(this).parent().find("#Cantidad").val();
         var url="Controlador?accion=ActualizarCantidad";
         $.ajax({
             type: 'POST',
             url: url,
             data: "idb="+idb+"&Cantidad="+cantidad,
             success: function (data, textStatus, jqXHR) {
                location.href="Controlador?accion=Carrito";
            }
         });
     });
});
