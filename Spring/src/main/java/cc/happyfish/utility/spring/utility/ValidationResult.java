package cc.happyfish.utility.spring.utility;

import java.util.Map;

/**
 * 作者:汪阳 <br>
 * 部门:计算机应用开发室 <br>
 * 联系:0553-8399022  <br>
 * 时间:2017/3/6 <br>
 * 说明:Hibernate Validator Utils( with Demo )
 * <p>
 * public class SimpleEntity {
 *
 * @NotBlank(message="名字不能为空或者空串")
 * @Length(min=2,max=10,message="名字必须由2~10个字组成") private String name;
 * @Past(message="时间不能晚于当前时间") private Date date;
 * @Email(message="邮箱格式不正确") private String email;
 * @Pattern(regexp="(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{5,10}",message="密码必须是5~10位数字和字母的组合") private String password;
 * @AssertTrue(message="字段必须为真") private boolean valid;
 * <p>
 * //get set方法省略
 * }
 * @Target( { METHOD, FIELD, ANNOTATION_TYPE })
 * @Retention(RUNTIME)
 * @Constraint(validatedBy = PasswordValidator.class)
 * @Documented public @interface Password {
 * <p>
 * String message() default "{密码必须是5~10位数字和字母组合}";
 * <p>
 * Class<?>[] groups() default {};
 * <p>
 * Class<? extends Payload>[] payload() default {};
 * }
 * <p>
 * public class PasswordValidator implements ConstraintValidator<Password, String> {
 * <p>
 * //5~10位的数字与字母组合
 * private static Pattern pattern = Pattern.compile("(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{5,10}");
 * <p>
 * public void initialize(Password constraintAnnotation) {
 * //do nothing
 * }
 * <p>
 * public boolean isValid(String value, ConstraintValidatorContext context) {
 * if( value==null ){
 * return false;
 * }
 * Matcher m = pattern.matcher(value);
 * return m.matches();
 * }
 * }
 * <p>
 * public class ExtendEntity {
 * @Password private String password;
 * <p>
 * public String getPassword() {
 * return password;
 * }
 * <p>
 * public void setPassword(String password) {
 * this.password = password;
 * }
 * <p>
 * }
 */
public class ValidationResult {
    //校验结果是否有错
    private boolean hasErrors;

    //校验错误信息
    private Map<String, String> errorMsg;

    public boolean isHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    public Map<String, String> getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Map<String, String> errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "ValidationResult [hasErrors=" + hasErrors + ", errorMsg="
                + errorMsg + "]";
    }

}
