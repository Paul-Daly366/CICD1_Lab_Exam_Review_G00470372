# CICD-1 Coding Test — Review, Improve and Reflect

**Student ID:**  G00470372

**Examination group:** A (Room Booking / JPQL) or B (OpenFeign):  B

**Original examination pull-request URL (`exam-work`):**  [Exam Repo](https://github.com/Paul-Daly366/CICD1-BookingService-PD/pull/1)

**New review repository URL:**  [Review Repo](https://github.com/Paul-Daly366/CICD1_Lab_Exam_Review_G00470372)

## 1. My original examination self-assessment


### Task 1 — /40

**My mark: 32/40**  

32/40 was reached by figuring out the percentages of each requirement and getting an average, and comparing with an initial deduced mark

Deduced Mark = 32/40, most requirements present and working as intended, but half of one of the requirements missing

95% for Booking Entity, RoomID, ACTIVE status, field validation

40% for Request/Response DTOs

Average = Sum of individual percentages / n of individual = 88%

33 = 40 * ( Average / 100 )

**Evidence from the original code (files, methods, working or missing requirements):**  

Booking Entity class present, contains required attributes, set up as an entity for persistence, and has the requested Validation indentation, all working and enforcing the requirements. Includes RoomID which is required to create an object of this class. Includes status which is set to Active on creating the object in the service layer. 

BookingService present and handles the logic when using Booking & BookingResponse objects.

BookingResponse present and functioning, however the DTO requirement is not fully met, as the project is missing the request DTO.

### Task 2 — /40

**My mark: 20/40**  

Deduced Mark = 20 / 40, A lot of code present that works and/or is correct, but OpenFeign is not present which means the remote room lookup requirement isn't met, as well as checking capacity when posting booking.

95% for Persistence, fully functional as far as I can tell.

80% for POST Booking, works as intended but missing OpenFeign functionality & specified POST body structure.

40% for Invalid input & capacity failures, contains input validation that works, but can't compare with the other microservice for capacity checking.

10% for Remote Room Lookup using Feign, originally had most of the client class coded, but somehow didn't add when committing, so missing from the pull request, therefore no files present for OpenFeign integration, only a DTO for room request is coded.

Average = Sum of individual percentages / n of individual = 56.25%

22.5 = 40 * ( Average / 100)

**Evidence from the original code:**  

POST method 'creatingBooking()' present and functional, but missing OpenFeign integration.

BookingRepository is present and fully functioning, is instantiated in the service layer and used in the 'createBooking()' and 'getBookingById()' methods.

BookingController is present, contains a POST method, 'createBooking()', which works as intended but does not utilize OpenFeign when creating Bookings.

Invalid Input is handled by Validation, but does not account for checking invalid capacity entries, this would have been handled with an OpenFeign interaction, but is missing in this project.

No OpenFeign classes or integration present, only a RoomRequest DTO, which would be more appropriately placed in the directory '../sample/client/dto/'.

### Task 3 — /20

**My mark: 19/20**

Deduced mark: 18 / 20, all requirements met and fully functional, Get method from database works as intended, response DTO returns instead of the original class, appropriate 404 error when the input booking id is not found. 

95% for the 3 requirements (GET method retrieving from database, response DTO & appropriate booking not found response).

Average = 95%

19 = 20 * ( Average / 100 )

**Evidence from the original code:**  

GET method coded in service and controller layer (both 'getBookingById()'), grabbing from the persistence layer, fully functioning and throws a 404 error when a booking is not found. Booking is returned as a DTO in both layers.

### Total self-assessed original examination mark: /100

Mathematically: 19 + 20 + 32 =  71 / 100

Deduced: ~ 60 / 100

Going closer to 60 as the maths may weigh certain requirements more than they should be.

**Final self-assessed mark: 65 / 100**

## 2. Corrections and improvements in my new project

Start from a **fresh copy of the starter template for your own exam group**, in a **new GitHub repository**. You may consult or selectively reuse your own original examination code, but the new project must demonstrate that you understand and can correct it. Do not change your original examination submission.

Describe **two or three important problems** in your original code. For each, explain what was wrong, which class or method you changed in the new project, and why the corrected approach works.

**Problem and correction 1:**  

**Problem and correction 2:**  

**Problem and correction 3 (optional):**  

## 3. API testing and evidence

Use Swagger UI or another HTTP client. For **at least four meaningful checks**, record the request/input, expected result, actual HTTP status/response, and pass/fail. Include unsuccessful cases; a running application alone is not enough.

**Test 1 — successful booking request:**  
- Request / input:  
- Expected:  
- Actual HTTP status / body:  
- Pass / fail:  

**Test 2 — invalid input or excessive attendee count:**  
- Request / input:  
- Expected:  
- Actual HTTP status / body:  
- Pass / fail:  

**Test 3 — missing booking or room:**  
- Request / input:  
- Expected:  
- Actual HTTP status / body:  
- Pass / fail:  

**Test 4 — requirement specific to my group:**  
- Request / input:  
- Expected:  
- Actual HTTP status / body:  
- Pass / fail:  

**Group A:** Demonstrate `GET /api/bookings/search?roomName=...` using an exact room name, bookings ordered by attendee count descending, and an empty list for no matches. Add checks if necessary to show all three behaviours.

**Group B:** Run the **provided** Room Service separately on port 8082 and the **new** Booking Service on port 8081. Demonstrate that booking creation obtains room details through OpenFeign and that booking retrieval uses the local Booking database. Do not modify the Room Service.

## 4. Reflection

**What did I understand during the examination but struggle to implement?**  

**Which Spring Boot, JPA, validation, JPQL or OpenFeign concept became clearer after correcting my code? Give a specific example.**  

**What will I do differently in my next coding test or API development task?**  

## Review lab assessment — 20 marks

- Honest original self-assessment with code evidence: **4 marks**
- Explanation of mistakes and Spring Boot concepts: **6 marks**
- Corrections in the new application: **4 marks**
- API testing and demonstration of understanding: **4 marks**
- Reflection and future improvement: **2 marks**

**Total: 20 marks.** Simply submitting a working solution does not demonstrate the learning required by this review.

## Proposed mark recovery — only if confirmed for CICD-1

If the same approach as OOP is adopted, the review could recover **up to 30% of marks lost** in the original examination, scaled by the review-lab mark.

**Marks recovered = (100 − official original exam mark) × 0.30 × (review lab mark ÷ 20)**

Example: exam **40/100** and review **16/20** → **14.4 recovered marks**, revised exam **54.4/100**. This is **not an approved CICD-1 policy unless confirmed by the lecturer**. The original official exam mark—not your self-awarded grade—is used in the calculation.

## Submission

Commit and push the **new review repository** with the completed README, corrected Spring Boot code and API-test evidence. Submit its GitHub URL on Moodle. **Do not push any changes to the original examination repository or `exam-work` pull request.**
