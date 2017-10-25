package local.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import local.domain.products.ProductSymbol;


@Path("/financial")
public class FinancialRestResource {

	@GET
	@Path("/product")
	@Produces("application/json")
	public List<ProductSymbol> getProducts() {
		List<ProductSymbol> result = new ArrayList<ProductSymbol>();
		ProductSymbol p = new ProductSymbol();
		p.setProductid("1");
		p.setCusip("22");
		p.setSymbol("$");
		p.setSymboltype(1);
		result.add(p);
		return result;
	}
}
