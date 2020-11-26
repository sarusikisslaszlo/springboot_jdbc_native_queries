package adatbazisok.com.bank.controller;

import adatbazisok.com.bank.entity.Bank;
import adatbazisok.com.bank.entity.BankAccount;
import adatbazisok.com.bank.entity.Client;
import adatbazisok.com.bank.entity.Transaction;
import adatbazisok.com.bank.service.interf.BankAccountService;
import adatbazisok.com.bank.service.interf.BankService;
import adatbazisok.com.bank.service.interf.ClientService;
import adatbazisok.com.bank.service.interf.TransactionService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BankController {

  @Autowired
  private BankAccountService bankAccountService;

  @Autowired
  private BankService bankService;

  @Autowired
  private ClientService clientService;

  @Autowired
  private TransactionService transactionService;

  @GetMapping("/home")
  public String saveTest(Model model) {
    Bank bank = new Bank();
    BankAccount bankAccount = new BankAccount();
    Client client = new Client();
    Transaction transaction = new Transaction();
    model.addAttribute("bankAccount", bankAccountService.findAll());
    model.addAttribute("newbankaccount", bankAccount);
    model.addAttribute("bank", bankService.findAll());
    model.addAttribute("newbank", bank);
    model.addAttribute("client", clientService.findAll());
    model.addAttribute("newclient", client);
    model.addAttribute("transaction", transactionService.findAll());
    model.addAttribute("newtransaction", transaction);
    model.addAttribute("avg", transactionService.queryTrans());
    model.addAttribute("listmin", bankAccountService.getBAlanceByBank());
    model.addAttribute("listsum", bankAccountService.getSumAmount());
    return "index";
  }

  @RequestMapping(value = "/save/banka", method = RequestMethod.POST)
  public String saveBankAccount(@Valid BankAccount bankAccount, BindingResult bindinresult) {
    if (bindinresult.hasErrors()) {
      return "index";
    }
    bankAccountService.saveBankAccount(bankAccount.getAccountNumber(), bankAccount.getBalance(), bankAccount.getType(), bankAccount.getUgyfelId(), bankAccount.getBankId());
    return "redirect:/home";
  }

  @GetMapping("/edit/banka/{id}")
  public String banka(@PathVariable("id") String id, Model model) {
    BankAccount bankAccount = bankAccountService.getById(id);
    model.addAttribute("bank", bankService.findAll());
    model.addAttribute("client", clientService.findAll());
    model.addAttribute("editankaccount", bankAccount);
    return "edit_bankaccount";
  }

  @RequestMapping(value = "/edit_banka", method = RequestMethod.POST)
  public String editBankAccount(@Valid BankAccount bankAccount, BindingResult bindinresult) {
    if (bindinresult.hasErrors()) {
      return "edit_bankaccount";
    }
    bankAccountService.updateById(bankAccount.getAccountNumber(), bankAccount.getBalance(), bankAccount.getType(), bankAccount.getUgyfelId(), bankAccount.getBankId());
    return "redirect:/home";
  }

  @GetMapping("/edit/transaction/{id}")
  public String transaction(@PathVariable("id") Long id, Model model) {
    Transaction transaction = transactionService.getById(id);
    model.addAttribute("bankAccount", bankAccountService.findAll());
    model.addAttribute("edittransaction", transaction);
    return "edit_transaction";
  }

  @RequestMapping(value = "/edit_transaction", method = RequestMethod.POST)
  public String editTransaction(@Valid Transaction transaction, BindingResult bindinresult) {
    if (bindinresult.hasErrors()) {
      return "edit_transaction";
    }
    transactionService.updateTransaction(transaction.getId(), transaction.getAmount(), transaction.getFromClient(), transaction.getToClient(), transaction.getDateTime(), transaction.getAccountNum());
    return "redirect:/home";
  }

  @GetMapping("/edit/client/{id}")
  public String client(@PathVariable("id") String id, Model model) {
    Client client = clientService.getById(id);
    model.addAttribute("editclient", client);
    return "edit_client";
  }

  @RequestMapping(value = "/edit_client", method = RequestMethod.POST)
  public String editClient(@Valid Client client, BindingResult bindinresult) {
    if (bindinresult.hasErrors()) {
      return "edit_client";
    }
    clientService.updateClient(client.getIdNum(), client.getName(), client.getBornDate(), client.getMotherName(), client.getCity(), client.getZipCode(), client.getStreet());
    return "redirect:/home";
  }

  @GetMapping("/edit/bank/{id}")
  public String bank(@PathVariable("id") Long id, Model model) {
    Bank bank = bankService.getById(id);
    model.addAttribute("editbank", bank);
    return "edit_bank";
  }

  @RequestMapping(value = "/edit_bank", method = RequestMethod.POST)
  public String editBank(@Valid Bank bank, BindingResult bindinresult) {
    if (bindinresult.hasErrors()) {
      return "edit_client";
    }
    bankService.updateBank(bank.getId(), bank.getName(), bank.getCity());
    return "redirect:/home";
  }

  @RequestMapping(value = "/save/bank", method = RequestMethod.POST)
  public String saveBank(@Valid Bank bank, BindingResult bindinresult) {
    if (bindinresult.hasErrors()) {
      return "index";
    }
    bankService.saveBank(bank.getName(), bank.getCity());
    return "redirect:/home";
  }

  @RequestMapping(value = "/save/client", method = RequestMethod.POST)
  public String saveClient(@Valid Client client, BindingResult bindinresult) {
    if (bindinresult.hasErrors()) {
      return "index";
    }
    clientService.saveClient(client.getIdNum(), client.getName(), client.getBornDate(), client.getMotherName(), client.getCity(), client.getZipCode(), client.getStreet());
    return "redirect:/home";
  }

  @RequestMapping(value = "/save/transaction", method = RequestMethod.POST)
  public String saveTransaction(@Valid Transaction transaction, BindingResult bindinresult) {
    if (bindinresult.hasErrors()) {
      return "index";
    }
    transactionService.saveTransaction(transaction.getAmount(), transaction.getFromClient(), transaction.getToClient(), transaction.getDateTime(), transaction.getAccountNum());
    return "redirect:/home";
  }

  @RequestMapping("/delete/banka/{id}")
  public String delete(@PathVariable String id) {
    bankAccountService.deleteBankAccountById(id);
    return "redirect:/home";
  }

  @RequestMapping("/delete/bank/{id}")
  public String deleteBank(@PathVariable Long id) {
    bankService.deleteBank(id);
    return "redirect:/home";
  }

  @RequestMapping("/delete/client/{id}")
  public String deleteClient(@PathVariable String id) {
    clientService.deleteClient(id);
    return "redirect:/home";
  }

  @RequestMapping("/delete/transaction/{id}")
  public String deleteTransaction(@PathVariable Long id) {
    transactionService.deleteTransaction(id);
    return "redirect:/home";
  }
}
