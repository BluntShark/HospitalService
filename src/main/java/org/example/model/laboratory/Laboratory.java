package org.example.model.laboratory;

import org.example.model.analysis.Analysis;

/**
 * @author
 * Класс Laboratory (Generic)
 */
public class Laboratory<T extends Analysis>{
    private Integer idLaboratory;
    private String labName;
    private String labNumber;
    public String getLabName() { return labName; }
    public void setLabName(String labName) { this.labName = labName; }
    public String getLabNumber() { return labNumber; }
    public void setLabNumber(String labNumber) { this.labNumber = labNumber; }
    public Integer getIdLaboratory() {
        return idLaboratory;
    }
    public void setIdLaboratory(Integer idLaboratory) {
        this.idLaboratory = idLaboratory;
    }
    @Override
    public String toString(){
        return "Laboratory [Laboratory Name: "
                + labName
                + ", Laboratory Number: "
                + labNumber
                + ", Laboratory ID: "
                + idLaboratory
                + "]";
    }
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()){
            return  false;
        }
        else{
            return true;
        }
    }
    @Override
    public int hashCode(){
        int total = 31;
        total = total * 31 + labName.hashCode();

        total = total * 31 + (labName == null ? 0 : labName.hashCode());
        return total;
    }
}
