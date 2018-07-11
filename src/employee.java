public class employee {
    private String first_name;
    private String last_name;
    private String birthday;
    private String email;
    private String phone_number;
    private String password_hash;
    public void setLast_name(String last_name){
        this.last_name = last_name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setPassword(String source){
        this.password_hash = md5Utils.encrypt32(source);
    }
    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public String getPhone_number() {
        return phone_number;
    }
}
