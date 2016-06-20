
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="saqueContaReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "saqueContaReturn"
})
@XmlRootElement(name = "saqueContaResponse")
public class SaqueContaResponse {

    protected boolean saqueContaReturn;

    /**
     * Obtém o valor da propriedade saqueContaReturn.
     * 
     */
    public boolean isSaqueContaReturn() {
        return saqueContaReturn;
    }

    /**
     * Define o valor da propriedade saqueContaReturn.
     * 
     */
    public void setSaqueContaReturn(boolean value) {
        this.saqueContaReturn = value;
    }

}
