package com.cg.DTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PurchaseBookDTO {

   private int bookId;
    private String username;
    private String useremail;
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUseremail() {
        return useremail;
    }
    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

}
