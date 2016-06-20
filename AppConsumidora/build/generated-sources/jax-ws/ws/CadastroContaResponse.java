
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
 *         &lt;element name="cadastroContaReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "cadastroContaReturn"
})
@XmlRootElement(name = "cadastroContaResponse")
public class CadastroContaResponse {

    protected boolean cadastroContaReturn;

    /**
     * Obtém o valor da propriedade cadastroContaReturn.
     * 
     */
    public boolean isCadastroContaReturn() {
        return cadastroContaReturn;
    }

    /**
     * Define o valor da propriedade cadastroContaReturn.
     * 
     */
    public void setCadastroContaReturn(boolean value) {
        this.cadastroContaReturn = value;
    }

}
