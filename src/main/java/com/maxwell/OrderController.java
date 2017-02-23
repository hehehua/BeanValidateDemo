package com.maxwell;

import com.maxwell.hibernate.validation.ValidationResult;
import com.maxwell.hibernate.validation.ValidationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2017/2/15 0015.
 */
@Controller
public class OrderController {

    @RequestMapping(value="/order", method= RequestMethod.GET)
    public String test(Model model){
        if(!model.containsAttribute("order")) {
            model.addAttribute("order", new Order());
        }
        return "order";
    }

    @RequestMapping(value="/order", method= RequestMethod.POST)
    public String test(@Valid Order order, BindingResult result, Model model){

        //StringBuffer buf = new StringBuffer();
//        if(result.hasErrors()){
//            List<ObjectError> list = result.getAllErrors();
//            for(ObjectError  error:list){
//                //buf.append("---"+error.getCode()+"-"+error.getArguments()+"-"+error.getDefaultMessage());
//                System.out.println(error.getCode()+"---"+error.getArguments()+"---"+error.getDefaultMessage());
//            }
//
//            return "order";
//        }
        ValidationResult validateResult = ValidationUtils.validateProperty(order,"email");
        System.out.println(validateResult);
        if(validateResult.isHasErrors()){
            System.out.println(validateResult.getErrorMsg());
            return "order";
        }
        return "message";
    }

   /* @RequestMapping(value="/order", method= RequestMethod.GET)
    public String test(Model model){
        if(!model.containsAttribute("order")) {
            model.addAttribute("order", new Order());
        }
        return "order";
    }

    @RequestMapping(value="/order", method= RequestMethod.POST)
    public String validateOrder(String orderId,String customer,String email,String address,String status,String pName,String price,HttpServletRequest req,Model model){
        // 将 Bean 放入 model 中
        Order order = new Order();
        order.setOrderId(orderId);
        order.setCustomer(customer);
        order.setEmail(email);
        order.setAddress(address);
        order.setStatus(status);
        order.setpName(pName);
        order.setPrice(price);
        model.addAttribute("order", order);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        if(violations.size() == 0) {
            return "message";
        }else{
            StringBuffer buf = new StringBuffer();
//            ResourceBundle bundle = ResourceBundle.getBundle("messages");
            for(ConstraintViolation<Order> violation: violations) {
//                buf.append("-" + bundle.getString(violation.getPropertyPath().toString()));
                buf.append(violation.getMessage() + "<BR>\n");
                System.out.println(buf.toString());
            }
            return "message";
        }
    }*/

}
