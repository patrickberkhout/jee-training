package local.products.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productsymbols")
public class ProductSymbol {
	
	@Id
	String  productid;
	Integer symboltype;
	String symbol;
	String cusip;
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public Integer getSymboltype() {
		return symboltype;
	}
	public void setSymboltype(Integer symboltype) {
		this.symboltype = symboltype;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getCusip() {
		return cusip;
	}
	public void setCusip(String cusip) {
		this.cusip = cusip;
	}
	

}
