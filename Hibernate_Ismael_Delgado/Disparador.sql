create or replace TRIGGER "LYNCHANIANO"."TRIGGERSTOCKS" 
INSTEAD OF INSERT OR DELETE OR UPDATE ON STOCKS 
declare
 
BEGIN
 
  if inserting then
   insert into DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD)
   values (:new.ID_COCESIONARIO,:new.CODCOCHE,:new.STOCK);
   
   
  elsif deleting then
  
    delete from DISTRIBUCION
    where CODCOCHE=:old.CODCOCHE and CIFC =:old.ID_COCESIONARIO;
   
  else
  
    update DISTRIBUCION
    
    set CANTIDAD=:new.stock
    where CODCOCHE=:new.CODCOCHE and CIFC =:new.ID_COCESIONARIO;
    
   end if;
END;