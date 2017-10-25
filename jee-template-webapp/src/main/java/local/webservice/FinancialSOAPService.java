package local.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import local.financialservice.FinancialService;
import local.financialservice.Product;

@WebService(endpointInterface = "local.financialservice.FinancialService")
public class FinancialSOAPService implements FinancialService {

	@Override
	public List<Product> getProducts() {
		List<Product> result = new ArrayList<Product>();
		result.add(getProduct("1"));
		result.add(getProduct("2"));
		return result;
	}

	@Override
	public Product getProduct(String productid) {
		Product result = new Product();
		result.setProductid(productid);
		result.setCuisp("cuisp");
		result.setSymbol("$");
		result.setSymboltype("Type1");
		return result;
	}

}
