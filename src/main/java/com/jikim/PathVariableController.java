package com.jikim;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/dwr")
public class PathVariableController {

    @GetMapping("chairs/{designerId}/material/{typeId}")
    public String findByName(
            @PathVariable int designerId,
            @PathVariable int typeId) {
        return String.format("Design Within Reach Chairs by %d of type %d", designerId, typeId);
    }

    @GetMapping("tables/{designerId}/material/{typeId}")
    public String findAsHashMap(@PathVariable Map pathVariables){
        return pathVariables.toString();
    }

    @GetMapping("lighting/{designerId}/material/{typeId}")
    public String findFromCustomObject(InventorySearchParams searchParams) {
        return String.format("Design Within Reach Lighting Fixtures by %s of type %d", searchParams.getDesignerId() , searchParams.getTypeId());
    }
}
