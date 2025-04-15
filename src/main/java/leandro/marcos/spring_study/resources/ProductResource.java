package leandro.marcos.spring_study.resources;

import leandro.marcos.spring_study.dtos.ProductDTO;
import leandro.marcos.spring_study.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ProductResource {

/*    public insert(@RequestBody Productdto){

    }
    */
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO dto){
        dto = ProductService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        dto = ProductService.delete(id);
        return ResponseEntity.ok().body(dto);
    }
}
