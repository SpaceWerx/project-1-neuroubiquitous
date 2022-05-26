package com.revature.repositories;

import com.revature.models.RbStatus;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReimbursementDAO {

    public List<Reimbursement> update(Reimbursement unprocessedReimbursement) {
        //try + catch block to catch sql exception that can be thrown with connection
        try (Connection connection = ConnectionFactoryUtility.getConnection()) {
            //Write the query that we want to send to the database and assign it to a String
            String sql = "Update ers_reimbursement SET resolver = ?, status = ?::status WHERE id = ?";

            //Creating a prepared statement with the sql string we recreated
            PreparedStatement preparedStatement = connection.preparedStatement(sql);

            //Setting the update parameters(?'s) with their respective values. //parameterIndex:
            preparedStatement.setInt(1, unprocessedReimbursement.getResolver());
            preparedStatement.setObject(2, unprocessedReimbursement.getStatus().name());
            preparedStatement.setInt(3, unprocessedReimbursement.getId());

            //executing the record update
            preparedStatement.executeUpdate();

            // Reimbursed!
            System.out.println("Reimbursement Successfully Updated!");

        } catch (SQLException e) {
            System.out.println("Updating Failed!"); //Reimbursement failed
            e.printStackTrace(); //useful debugging tool

    /*This method is intended to extracted any reimbursements from the database that were submitted
    by a specific user, whose ID is passed in as a parameter

    @return List of reimbursement created by author with matching userId
     */


            public List<Reimbursement> getReimbursementByUser ( int userId){

                //try*catch block to catch sql exception that can be thrown with connection
                try (Connection connection = ConnectionFactoryUtility.getConnection()) {

                    // SQL statement prepared as a string
                    // In this instance, we are filtering reimbursements by an author (user) id
                    String sql = *select * from ers_reimbursement where author = ?";

                    //Preparing the sql statement to be executed once we will fill the query parameters
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);

                    //Filling the missing query value (?) with the method parameter (userId)
                    preparedStatement.setInt(parameterIndex:1, userId);
                    //Building a sql result set from the execution of the query statement
                    ResultSet resultSet = preparedStatement.executeQuery();
                    //Initializing a new Reimbursement array list to house and return with the data from the database
                    List<Reimbursement> reimbursements = new Arraylist<>();

                    //This while loop will continue to add reimbursements to the list
                    //until all the data from the result set has run out
                    while (resultSet.next()) {
                        //Adding reimbursements to the list with the data extracted from the database
                        reimbursements.add(new Reimbursement(
                                resultSet.getInt("id"),
                                resultSet.getInt("author"),
                                resultSet.getInt("resolver"),
                                resultSet.getString("description"),
                                RbType.valueOf(resultSet.getString("type")),
                                RbStatus.valueOf(resultSet.getString("status")),
                                resultSet.getDouble("amount")
                        ));

                    }
                    //Return the list of reimbursement that have a matching author (user) id
                    return reimbursements;

                } catch reimbursements;

                //catching the sql exception (this is a good place to utilize custom exception handling)
                System.out.println("Something Went Wrong Obtaining Your List!");
                e.printStackTrace();

            }

            //Fail-safe if the try-catch block does not run
            return null;

            /* Should retrieve a Reimbursement from the DB with the corresponding id or null if there is no match.

             */
            public Reimbursement getReimbursementById ( int id){
                // try + catch block to catch sql exception that can be thrown with connection
                try (Connection connection = ConnectionFactoryUtility.getConnection()) {
                    String sql = "select * from ers_reimbursement where id =?";

                    //when we need parameters we need to use a PREPARED Statement, as opposed to a Statement (seen above)
                    PreparedStatement preparedStatement = connection.prepareStatement(sql); //prepareStatement() as opposed to createStatement()

                    //insert the methods argument (int id) as the first (and only) variable in our SQL query
                    preparedStatement.set, id); //1 here is referring to the first parameter(?_ found in our SQL String

                    ResultSet resultSet = preparedStatement.executeQuery();

                    //if there are results in the result set....
                    if (resultSet.next()) {
                        //return a reimbursement with the data to be returned to the service layer
                        return new Reimbursement(
                                resultSet.getInt("id"),
                                resultSet.getInt("author"),
                                resultSet.getInt("resolver"),
                                resultSet.getString("description"),
                                RbType.valueOf(resultSet.getSTring("type")),
                                RbStatus.valueOf(resultSet.getString("status")),
                                resultSet.getDouble("amount")
                        );
                    }
                } catch (SQLException e) {
                    System.out.println("Something went wrong with the database!");
                    e.printStackTrace();
                }
                //Fail-safe if the try+catch block does not run
                return null;

                /*4Should retrieve a list of reimbursement from the DB with the corresponding Status or an empty list if there are no matches.
                 */
                public List<Reimbursement> getByStatus (Status status){
                    //try+catch block to catch sql exception that be thrown with connection
                    try (Connection connection = ConnectionFactoryUtility.getConnection()) {
                        //write the query that we want to send to the database and assign it to a String
                        String sql = "select * from ers_reimbursements where status = ?"::status ";
                        //Put the SQL query into a Statement object (The connection object has a method for this !! implicit?)
                        PreparedStatement preparedStatement = connection.preparedStatement(sql);
                        preparedStatement.setString(1, status.toString());
                        //Execute the Query by putting the results of the query into our ResultSet object (resultSet)
                        //The Statement object has a method that takes Strings to execute as a SQL query
                        ResultSet resultSet = preparedStatement.executeQuery();

                        //ALL THE CODE ABOVE MAKES A CALL TO THE DATABASE. Now we need to store the data in the an ArrayList.
                        //create an empty ArrayList to be filled with the data from the database
                        List<Reimbursement> reimbursements = new ArrayList<>(); //Upcasting, we are instantiating an ArrayList
                        //while there are results in the results
                        while (resultSet.next()) {
                            //Use the all args constructor to create a new User object from each returned row from the DB
                            reimbursements.add(new Reimbursement(
                                    resultSet.getInt("id"),
                                    resultSet.getInt("author"),
                                    resultSet.getInt("resolver"),
                                    resultSet.getInt("description"),
                                    RbType.valueOf(resultSet.getString("type")),
                                    RbStatus.valueOf(resultSet.getString("status")),
                                    resultSet.getDouble("amount")
                            ));

                        }
                        //when there are no more results in resultSet, the while loop will break
                        //then, return the populated ArrayList of Users
                        return reimbursements;

                    } catch (SQLException e) {
                        System.out.println("Something went wrong with reimbursement transaction");
                        e.printStackTrace();

                    }
                    //Fail-safe if the try+catch block does not run
                    return null;

    /*The getAllReimbursemens method retrieves all reimbursement records from the database
    this method should return an array list of reimbursement or null if there is a connection error
     */
                    public List<Reimbursement> getAllReimbursements () {
                        //try+catch block to catch sql exception that can be thrown with connection
                        try (Connection connection = ConnectionFactoryUtility.getConnection()) {
                            //Instantiate a new arrayList to store the records from the database
                            List<Reimbursement> reimbursements = new ArrayList<>();

                            //write out the appropriate sql query string
                            String sql = "Select * from ers_reimbursements";
                            // we can use createStatement in this case because we do not have any parameters in the query
                            Statement statement = connection.createStatement();

                            //storing the records from query in a result set
                            ResultSet resultSet = statement.executeQuery(sql);
                            //Looping over the records from the query to then add to the return list
                            while (resultSet.net()) {
                                reimbursements.add(new Reimbursement(
                                        resultSet.getInt("id"),
                                        resultSet.getInt("author"),
                                        resultSet.getInt("resolver"),
                                        resultSet.getInt("description"),
                                        RbType.valueOf(resultSet.getString("type")),
                                        RbStatus.valueOf(resultSet.getString("status")),
                                        resultSet.getDouble("amount")
                                ));
                            }
                            //returning the list of records after the result set runs out
                            return reimbursements;
                        } catch (SQLException sqlException) {
                            System.out.println("Something went wrong with the database!");
                            sqlException.printStackTrace();

                        }
                        //Fail-safe if the try+catch block does not run
                        return null;
                        /*The create method is meant to create a new record in the database for new reimbursement submissions

                         */
                        public int create (Reimbursement reimbursementToBeSubmitted){
                            // try+catch block to catch sql exception that can be thrown with connection
                            try (Connection connection = ConnectionFactoryUtility.getConnection()) {
                                //writing out the (relatively complex) sql insert string to create a new record
                                // we explicitly ask the database to return the new id after entry
                                String sql = "INSERT INTO ers_reimbursements (author, description, type, status, amount)"
                                        + "VALUES (?, ?, ?::type, ?::status, ?)"
                                        + "RETURNING ers_reimbursements_id";

                                //We must use a prepared statement because we have parameters
                                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                                //use the PreparedStatement objects 'methods to insert values into the query's ?s
                                //the values will come from the Reimbursement object we send in.
                                preparedStatement.setInt(1, reimbursementToBeSubmitted.getAuthor());
                                preparedStatement.setString(2, reimbursementToBeSubmitted.getDescription());
                                preparedStatement.setObject(3, reimbursementToBeSubmitted.getType().name());
                                preparedStatement.setObject(4, reimbursementToBeSubmitted.getStatus().name());
                                preparedStatement.setDouble(5, reimbursementToBeSubmitted, getAmount());

                                //We need to use the result set to retrieve the newly generated ID after entry of the new record
                                ResultSet resultSet;

                                //Here, we are checking that the sql query executed and returned the reimbursement record with the new id
                                if ((resultSet = preparedStatement.executeQuery()) != null) {
                                    //must call this to get the returned reimbursement record id
                                    resultSet.next();
                                    //finally returning the new id
                                    return resultSet.getInt(1); //not seeing this
                                }

                            } catch (SQLException e) {
                                System.out.println("Creating reimbursement has failed");
                                e.printStackTrace();
                            }
                            //Fail-safe if the try+catch block does not run
                            return 0;

                        }
