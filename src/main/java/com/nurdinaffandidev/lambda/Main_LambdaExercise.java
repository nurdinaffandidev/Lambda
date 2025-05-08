package com.nurdinaffandidev.lambda;

import java.util.*;
import java.util.function.*;

public class Main_LambdaExercise {
    public static void main(String[] args) {
        // Bank Account objects
        BankAccount account1 = new BankAccount(12345678, 987654, "Mr J Smith", "savings", 1.1, 25362.91);
        BankAccount account2 = new BankAccount(87654321, 234567, "Ms J Jones", "current", 0.2, 550);
        BankAccount account3 = new BankAccount(74639572, 946284, "Dr T Williams", "savings", 1.1, 4763.32);
        BankAccount account4 = new BankAccount(94715453, 987654, "Ms S Taylor", "savings", 1.1, 10598.01);
        BankAccount account5 = new BankAccount(16254385, 234567, "Mr P Brown", "current", 0.2, -195.74);
        BankAccount account6 = new BankAccount(38776543, 946284, "Ms F Davies", "current", 0.2, -503.47);
        BankAccount account7 = new BankAccount(87609802, 987654, "Mr B Wilson", "savings", 1.1, 2.5);
        BankAccount account8 = new BankAccount(56483769, 234567, "Dr E Evans", "current", 0.2, -947.72);

        /*
            Predicate<T> – takes a parameter and returns a boolean.
            Function<T, R> – takes a parameter of type T and returns a result of type R.
            Consumer<T> – takes a parameter and returns nothing.
            Supplier<T> – returns a value of type T.

            // Operators: similar to 'Function' but return type is same as argument while 'Function' needs to specify return type.
            // Operators extends 'Function'
            UnaryOperator<T> (1 argument)- returns a value of type T.
            BinaryOperator<T> (2 arguments)- returns a value of type T.
         */

        System.out.println("=============== 1.2 [Writing lambdas to implement functional interaces] ===============");
        // 1.2.1 -- FUNCTION (apply)
        /*
        1.	Write a lambda expression which implements the Function interface.
            It should take a bank account as an argument and return a String containing the customer’s name and balance.
            Test using account3 (should return “Dr T Williams: 4763.32”) and account4 (should return “Ms S Taylor: 10598.01”)
         */
        System.out.println("question 1.2.1");
        System.out.println("============================================");
        Function<BankAccount, String> nameAndBalance = account -> {
            return "Account holder name: " + account.getAccountHolder() + ", Balance = $" + account.getBalance();
        };
        System.out.println(nameAndBalance.apply(account3));
        System.out.println(nameAndBalance.apply(account4));

        // 1.2.2 -- FUNCTION (apply)
        /*
        2.	Write a lambda expression which implements the Function interface.
        It should take a bank account as an argument and return a double containing the amount of interest due on the account.
        This can be calculated as follows: balance * interest rate / 100.
        Test this using account2. It should return 1.1.
         */
        System.out.println("\nquestion 1.2.2");
        System.out.println("============================================");
        Function<BankAccount, Double> interestDue = account -> {
          return (account.getBalance() * account.getInterestRate()) / 100;
        };

        System.out.println("Interest due for account2 = " + interestDue.apply(account2));

        // 1.2.3 -- FUNCTION (apply)
        /*
        3.	Write a modified version of your previous lambda expression which returns 0 if the account is overdrawn.
            Test with account2 (should return 1.1) and account8 (should return 0.0).
            You will need to use a ternary operator.
         */
        System.out.println("\nquestion 1.2.3");
        System.out.println("============================================");
        Function<BankAccount, Double> interestDueOverdrawnChecked = account -> {
            return account.getBalance() > 0 ? (account.getBalance() * account.getInterestRate()) / 100 : 0.0;
        };

        System.out.println("Interest due for account2 = " + interestDueOverdrawnChecked.apply(account2));
        System.out.println("Interest due for account8 = " + interestDueOverdrawnChecked.apply(account8));

        // 1.2.4 -- PREDICATE (test)
        /*
        4.	Write a lambda expression which implements the Predicate interface.
            It should take a bank account as an argument.
            If the bank account is a current account the expression should return true,
            otherwise it should return false.
            Test with account1 (should return false) and account6 (should return true)
         */
        System.out.println("\nquestion 1.2.4");
        System.out.println("============================================");
        Predicate<BankAccount> isCurrentAccount = account -> {
          return account.getAccountType().equalsIgnoreCase("current");
        };
        System.out.println("account1 is current account = " + isCurrentAccount.test(account1));
        System.out.println("account6 is current account = " + isCurrentAccount.test(account6));

        // 1.2.5 -- PREDICATE (test)
        /*
        5.	Write a lambda expression which implements the Predicate interface.
            It should take a bank account as an argument.
            If the bank account is overdrawn it should return true, otherwise it should return false.
            Test with account5 (should return true) and account7 (should return false)
         */
        System.out.println("\nquestion 1.2.5");
        System.out.println("============================================");
        Predicate<BankAccount> isAccountOverdrawn = account -> {
            return account.getBalance() <= 0;
        };

        System.out.println("account5 is overdrawn = " + isAccountOverdrawn.test(account5));
        System.out.println("account7 is overdrawn = " + isAccountOverdrawn.test(account7));

        // 1.2.6 -- BINARY OPERATOR (apply)
        /*
        6.	Write a lambda expression which implements the BinaryOperator interface.
            It should take 2 bank accounts as arguments and return the bank account which has the highest balance.
            Test using account3 and account4 as arguments, it should return account4 (balance is 10598.01).
            You will need to use a ternary operator.
         */
        System.out.println("\nquestion 1.2.6");
        System.out.println("============================================");
        BinaryOperator<BankAccount> accountWithHighestBalance = (account_x, account_y) -> {
            return account_x.getBalance() > account_y.getBalance() ? account_x : account_y;
        };

        BankAccount accountWithHigherBalance = accountWithHighestBalance.apply(account3, account4);
        System.out.println("Account with highest balance (account3, account4) = " + accountWithHigherBalance.toString());

        // 1.2.7 -- CONSUMER (accept)
        /*
        7.	Write a lambda expression which implements the Consumer interface.
            It should take a bank account as an argument.
            It should then deduct a $10 fee from the balance.
            Test using account2 and account6.
            Call the getBalance() method on the two objects to check that their balances have been updated
            (account2 should be 540.0 and account6 should be -513.47).
         */
        System.out.println("\nquestion 1.2.7");
        System.out.println("============================================");
        Consumer<BankAccount> deduct10DollarFee = account -> {
          account.setBalance(account.getBalance() - 10);
        };

        System.out.println("account2 balance before $10 fee deduction = " + account2.getBalance());
        deduct10DollarFee.accept(account2);
        System.out.println("account2 balance after $10 fee deduction = " + account2.getBalance());

        System.out.println("account6 balance before $10 fee deduction = " + account6.getBalance());
        deduct10DollarFee.accept(account6);
        System.out.println("account6 balance after $10 fee deduction = " + account6.getBalance());

        // 1.2.8 -- BI CONSUMER (accept)
        /*
        8.	Write a lambda expression which implements the BiConsumer interface.
            It should take 2 arguments: a bank account and an integer.
            It should deduct the integer value from the account’s balance.
            Test using account1 and 100. The getBalance() method should show that account1’s balance is now 25262.91.
            Also test with account5 and 50. The balance afterwards should be -245.74
         */
        System.out.println("\nquestion 1.2.8");
        System.out.println("============================================");
        BiConsumer<BankAccount, Integer> deductAmount = (account, amountToDeduct) -> {
            account.setBalance(account.getBalance() -  amountToDeduct);
        };

        System.out.println("account1 balance before $100 deduction = " + account1.getBalance());
        deductAmount.accept(account1, 100);
        System.out.println("account1 balance after $100 deduction = " + account1.getBalance());

        System.out.println("account5 balance before $50 deduction = " + account5.getBalance());
        deductAmount.accept(account5, 50);
        System.out.println("account5 balance after $50 deduction = " + account5.getBalance());


        System.out.println("\n=============== 1.3 [Writing lambdas for List methods] ===============");
        /*
        1.	Create an ArrayList of type com.nurdinaffandidev.lambda.BankAccount. Add all the com.nurdinaffandidev.lambda.BankAccount objects to it.
         */
        System.out.println("\nquestion 1.3.1");
        System.out.println("============================================");
        List<BankAccount> bankAccountList = new ArrayList<>(Arrays.asList(account1, account2, account3, account4, account5, account6, account7, account8));
        System.out.println("Bank Accounts list:");
        for(BankAccount account : bankAccountList) {
            System.out.println(account);
        }

        /*
        2.	Call the ArrayList’s forEach method using a lambda expression to display the
            account number, account holder, their account type and their balance.
         */
        System.out.println("\nquestion 1.3.2");
        System.out.println("============================================");
        bankAccountList.forEach(account -> {
            System.out.print("Account number: " + account.getAccountNumber());
            System.out.print(", Account holder: " + account.getAccountHolder());
            System.out.print(", Account balance = " + account.getBalance());
            System.out.println();
        });

         /*
        3.	Call the ArrayList’s forEach method using a lambda expression to deduct $10 from each account’s balance.
            Test by running the code from question 2.
         */
        System.out.println("\nquestion 1.3.3");
        System.out.println("============================================");
        Consumer<BankAccount> getDetails = account -> {
            System.out.print("Account number: " + account.getAccountNumber());
            System.out.print(", Account holder: " + account.getAccountHolder());
            System.out.print(", Account balance deduction = " + account.getBalance());
            System.out.println();
        };
        bankAccountList.forEach(account -> {
            System.out.println("Before $10 deduction:");
            getDetails.accept(account);
            System.out.println("After $10 deduction:");
            deduct10DollarFee.accept(account);
            getDetails.accept(account);
        });

         /*
         4.	Call the ArrayList’s removeIf method using a lambda expression to remove accounts which are overdrawn by more than £500.
            Test by running the code from question 2.
         */
        System.out.println("\nquestion 1.3.4");
        System.out.println("============================================");
        bankAccountList.removeIf(account -> {
            return account.getBalance() < -500;
        });
        bankAccountList.forEach(account -> {
            System.out.println(account);
        });

         /*
         5.	Call the ArrayList’s removeIf method using a lambda expression to remove savings accounts.
            Test by running the code from question 1.
         */
        System.out.println("\nquestion 1.3.5");
        System.out.println("============================================");
        List<BankAccount> bankAccountCurrentList = new ArrayList<>(Arrays.asList(account1, account2, account3, account4, account5, account6, account7, account8));
        bankAccountCurrentList.removeIf(account -> {
           return account.getAccountType().equalsIgnoreCase("savings");
        });
        bankAccountCurrentList.forEach( account -> System.out.println(account));

        System.out.println("\n=============== 1.4 [Writing lambdas for Comparators] ===============");
        List<BankAccount> sortedAccountList = new ArrayList<>(Arrays.asList(account1, account2, account3, account4, account5, account6, account7, account8));
         /*
          1. Write a lambda expression to implement the Comparator interface.
             It should sort the ArrayList by account balance.
             Pass the comparator into the ArrayList’s sort method.
             Test by running the code from question 1.3.2.
         */
        System.out.println("\nquestion 1.4.1");
        System.out.println("============================================");
        Comparator<BankAccount> accountBalanceComparator = (firstAccount, secondAccount) ->
                ((Double) firstAccount.getBalance()).compareTo((Double) secondAccount.getBalance());
        sortedAccountList.sort(accountBalanceComparator);

        // alternative: direct comparator implementation in sort function
//        sortedAccountList.sort((firstAccount, secondAccount) -> {
//            return Double.compare(firstAccount.getBalance(), secondAccount.getBalance());
//        });

        sortedAccountList.forEach(account -> System.out.println(account));

        /*
          2. Write a lambda expression to implement the Comparator interface.
             It should sort the ArrayList by account type.
             Pass the comparator into the ArrayList’s sort method.
             Test by running the code from question 1.3.2.
         */
        System.out.println("\nquestion 1.4.2");
        System.out.println("============================================");
//        Comparator<com.nurdinaffandidev.lambda.BankAccount> accountTypeComparator = (firstAccount, secondAccount) -> {
//            return firstAccount.getAccountType().compareTo(secondAccount.getAccountType());
//        };
//        sortedAccountList.sort(accountTypeComparator);

        // alternative: direct comparator implementation in sort function
        sortedAccountList.sort((firstAccount, secondAccount) -> {
            return firstAccount.getAccountType().compareTo(secondAccount.getAccountType());
        });

        sortedAccountList.forEach(account -> System.out.println(account));

        /*
         3.	Write a lambda expression to implement the Comparator interface.
            It should sort the ArrayList by account number.
            Pass the comparator into the ArrayList’s sort method.
            Test by running the code from question 1.3.2.
         */
        System.out.println("\nquestion 1.4.3");
        System.out.println("============================================");
        Comparator<BankAccount> accountNumberComparator = (firstAccount, secondAccount) -> {
            return firstAccount.getAccountNumber() - secondAccount.getAccountNumber();
        };
        sortedAccountList.sort(accountNumberComparator);

        // alternative: direct comparator implementation in sort function
//        sortedAccountList.sort((firstAccount, secondAccount) -> {
//            return firstAccount.getAccountNumber() - secondAccount.getAccountNumber();
//        });
        sortedAccountList.forEach(account -> System.out.println(account));

        /*
        4.	Combine the comparators from questions 3 and 4 to make a new comparator which sorts by account type and then account balance.
            Test by running the code from question 1.3.2.
         */
        System.out.println("\nquestion 1.4.4");
        System.out.println("============================================");
        Comparator<BankAccount> accountTypeThenAccountBalanceComparator = accountBalanceComparator.thenComparing(accountBalanceComparator);
        sortedAccountList.sort(accountTypeThenAccountBalanceComparator);
        sortedAccountList.forEach(account -> System.out.println(account));

        System.out.println("\n=============== 1.5 [Writing lambdas for Map.merge()] ===============");
        /*
        1.	Create a Map of type <Integer,Integer>.
            The key will represent the bank code.
            The value will represents the number of bank accounts for that bank code.
         */
        System.out.println("\nquestion 1.5.1");
        System.out.println("============================================");
        List<BankAccount> bankAccountToMapList = new ArrayList<>(Arrays.asList(account1, account2, account3, account4, account5, account6, account7, account8));
        Map<Integer, Integer> bankCodeNumOfAccountMap = new HashMap<>();

        /*
        2.	Loop through the List of bank accounts.
            Use the Map.merge() method to populate the Map.
            Do not use the put method.
         */
        System.out.println("\nquestion 1.5.2");
        System.out.println("============================================");
        BiFunction<Integer, Integer, Integer> addToCount = (currentValue, amountToAdd) -> {
            return currentValue + amountToAdd;
        };
        bankAccountToMapList.forEach(account -> {
            bankCodeNumOfAccountMap.merge(account.getBankCode(),1, addToCount);
        });
        System.out.println("Bank Code : Number of Accounts");
        bankCodeNumOfAccountMap.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });

        /*
        3.	Create another Map, this time of type <Integer,Double>.
            The key will represent the bank code.
            The value will represent the sum of the account balances for that bank code.
         */
        System.out.println("\nquestion 1.5.3");
        System.out.println("============================================");
        Map<Integer, Double> bankCodeSumBalanceMap = new HashMap<>();
        BiFunction<Double, Double, Double> sumBalance = (currentBalance, accBalanceToAdd) -> {
            return currentBalance + accBalanceToAdd;
        };
        bankAccountToMapList.forEach(account -> {
            bankCodeSumBalanceMap.merge(account.getBankCode(), account.getBalance(), sumBalance);
            // alternative: direct implementation of BiFunctions in merge function
//            bankCodeSumBalanceMap.merge(
//                    account.getBankCode(),
//                    account.getBalance(),
//                    (currentBalance, balanceToAdd) -> {
//                        return currentBalance + balanceToAdd;
//                    });
        });
        System.out.println("Bank Code : Total Balance");
        bankCodeSumBalanceMap.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }
}
