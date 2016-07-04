package su.vistar.testtask_netcracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author dantonov
 */
public class TableDto {
    
    
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("desc")
    private String desc;

    
    
    public TableDto() { }

    public TableDto(Integer id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    
    
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }
    
    

}
