package su.vistar.testtask_netcracker.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author dantonov
 */

@Entity
@javax.persistence.Table(schema = "TestTask", name = "Table", catalog = "TestTask")
public class TableEntity implements Serializable {

    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "name", nullable = false, length = 31)
    private String name;
    
    @Column(name = "description", nullable = false, length = 255)
    private String desc;

    
    
    
    public TableEntity() { }

    public TableEntity(Integer id, String name, String desc) {
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

    
    
    @Override
    public int hashCode() {
        
        HashCodeBuilder hcb = new HashCodeBuilder();
        
        hcb.append(id);
        hcb.append(name);
        hcb.append(desc);
        
        return hcb.toHashCode();
        
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof TableEntity)) return false;
        
        TableEntity other = (TableEntity) obj;
        
        EqualsBuilder eb = new EqualsBuilder();
        
        eb.append(this.id, other.id);
        eb.append(this.name, other.name);
        eb.append(this.desc, other.desc);
        
        return eb.isEquals();
    }
    
    
    
    
}
