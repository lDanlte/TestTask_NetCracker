package su.vistar.testtask_netcracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author dantonov
 */
public class ResponseMessageDto {

    
    
    @JsonProperty("msg")
    private String msg;

    
    
    public ResponseMessageDto() { }

    public ResponseMessageDto(String msg) { this.msg = msg; }

    
    
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    
}
