
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
 *         &lt;element name="cadastroContaNovoReturn" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "cadastroContaNovoReturn"
})
@XmlRootElement(name = "cadastroContaNovoResponse")
public class CadastroContaNovoResponse {

    protected int cadastroContaNovoReturn;

    /**
     * Obtém o valor da propriedade cadastroContaNovoReturn.
     * 
     */
    public int getCadastroContaNovoReturn() {
        return cadastroContaNovoReturn;
    }

    /**
     * Define o valor da propriedade cadastroContaNovoReturn.
     * 
     */
    public void setCadastroContaNovoReturn(int value) {
        this.cadastroContaNovoReturn = value;
    }

}
