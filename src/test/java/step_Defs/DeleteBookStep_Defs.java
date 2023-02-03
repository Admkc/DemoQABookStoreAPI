package step_Defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.hu.De;
import services.Deletebook;

public class DeleteBookStep_Defs {

    Deletebook deletebook=new Deletebook();


    @Given("User should delete a book")
    public void user_should_delete_a_book() {
        deletebook.deleteABook();

    }

    @Then("User should verify deleteStatus code")
    public void user_should_verify_book() {
      deletebook.verifyDelete();
    }



}
