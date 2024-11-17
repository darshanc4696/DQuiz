<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "navbar.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DQuiz - Home</title>
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<!-- 
    Navbar
    <header class="navbar">
        <div class="container">
            <div class="logo">DQuiz</div>
            <nav>
                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">About</a></li>
               <li><a href="#">Categories</a> 
                        <select>
                            <option value="science">Science</option>
                            <option value="math">Math</option>
                            <option value="history">History</option>
                            <option value="tech">Tech</option>
                        </select>
                    </li>
                    <li><a href="#">Leaderboard</a></li>
                    <li><a href="/quizess/login" class="signin">Sign In</a></li>
                    <li><a href="#" class="signup">Sign Up</a></li>
                </ul>
            </nav>
        </div>
    </header> -->

    <!-- Hero Section -->
    <section class="hero">
        <div class="container">
            <h1>Challenge Your Knowledge!</h1>
            <p class="quote">"Learning is a treasure that will follow its owner everywhere."</p>
        </div>
    </section>

    <!-- Leaderboard Section -->
    <section class="leaderboard">
        <div class="container">
            <h2>Leaderboard</h2>
            <p>Top scorers of the week:</p>
            <div class="leaderboard-table">
                <!-- Leaderboard content fetched from database -->
                <table>
                    <tr>
                        <th>Rank</th>
                        <th>Username</th>
                        <th>Category</th>
                        <th>Score</th>
                    </tr>
                    <!-- Example entries -->
                    <tr>
                        <td>1</td>
                        <td>PlayerOne</td>
                        <td>Science</td>
                        <td>95</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>PlayerTwo</td>
                        <td>Science</td>
                        <td>90</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>PlayerThree</td>
                        <td>Science</td>
                        <td>85</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>PlayerThree</td>
                        <td>Science</td>
                        <td>85</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>PlayerThree</td>
                        <td>Science</td>
                        <td>85</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>PlayerThree</td>
                        <td>Science</td>
                        <td>85</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>PlayerThree</td>
                        <td>Science</td>
                        <td>85</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>PlayerThree</td>
                        <td>Science</td>
                        <td>85</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>PlayerThree</td>
                        <td>Science</td>
                        <td>85</td>
                    </tr>
                </table>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer class="footer">
        <div class="container">
            <p>&copy; 2024 DQuiz. All Rights Reserved.</p>
            <nav>
                <ul>
                    <li><a href="#">Privacy Policy</a></li>
                    <li><a href="#">Terms of Service</a></li>
                    <li><a href="#">Contact Us</a></li>
                </ul>
            </nav>
        </div>
    </footer>

</body>
</html>
