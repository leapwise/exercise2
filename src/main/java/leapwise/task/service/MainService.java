package leapwise.task.service;



import leapwise.task.parser.BooleanExpressionParser;
import leapwise.task.parser.JSParser;
import leapwise.task.persistence.model.RootNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leapwise.task.persistence.CustomerRepo;
import leapwise.task.persistence.ExpressionRepo;
import leapwise.task.persistence.model.Expression;


@Service
public class MainService {

	private final Logger logger = LogManager.getLogger(MainService.class);

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private ExpressionRepo expressionRepo;

	public MainService(CustomerRepo customerRepo, ExpressionRepo expressionRepo) {
		this.customerRepo = customerRepo;
		this.expressionRepo = expressionRepo;
	}

	public String executeLogicalExpression(int id, RootNode rootNode) {

		customerRepo.save(rootNode);

		Expression expression = expressionRepo.getById(id);

		String result = "";

		if (expression.getName().trim().equalsIgnoreCase("complex logical expression")) {
			BooleanExpressionParser booleanParser = new BooleanExpressionParser();

			result = booleanParser.evaluateExpression(expression.getValue(), rootNode);

			logger.info("Evaluated boolean expression result: {}", result);

		}  else if (expression.getName().trim().equalsIgnoreCase("javascript")) {

			JSParser javaScriptParser = new JSParser();

			result = javaScriptParser.evaluateExpression(expression.getValue(), rootNode);
			logger.info("Evaluated JavaScript expression result: {}", result);
		} else {
			logger.info("Not implemented");
		}

		return result;
	}

	public String saveExpression(Expression expression) {

		expressionRepo.save(expression);

		return Integer.toString(expression.getId());
	}
}
