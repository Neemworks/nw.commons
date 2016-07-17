package nw.commons;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit unit tests for BCrypt routines
 * @author Damien Miller
 * @version 0.2
 */
public class BCryptTest {

	String test_vectors[][] = {
			{ "", 
			"$2a$06$DCq7YPn5Rq63x1Lad4cll.",
			"$2a$06$DCq7YPn5Rq63x1Lad4cll.TV4S6ytwfsfvkgY8jIucDrjc8deX1s." },
			{ "",
			"$2a$08$HqWuK6/Ng6sg9gQzbLrgb.",
			"$2a$08$HqWuK6/Ng6sg9gQzbLrgb.Tl.ZHfXLhvt/SgVyWhQqgqcZ7ZuUtye" },
			{ "",
			"$2a$10$k1wbIrmNyFAPwPVPSVa/ze",
			"$2a$10$k1wbIrmNyFAPwPVPSVa/zecw2BCEnBwVS2GbrmgzxFUOqW9dk4TCW" },
			{ "",
			"$2a$12$k42ZFHFWqBp3vWli.nIn8u",
			"$2a$12$k42ZFHFWqBp3vWli.nIn8uYyIkbvYRvodzbfbK18SSsY.CsIQPlxO" },
			{ "a",
			"$2a$06$m0CrhHm10qJ3lXRY.5zDGO",
			"$2a$06$m0CrhHm10qJ3lXRY.5zDGO3rS2KdeeWLuGmsfGlMfOxih58VYVfxe" },
			{ "a", 
			"$2a$08$cfcvVd2aQ8CMvoMpP2EBfe",
			"$2a$08$cfcvVd2aQ8CMvoMpP2EBfeodLEkkFJ9umNEfPD18.hUF62qqlC/V." },
			{ "a",
			"$2a$10$k87L/MF28Q673VKh8/cPi.",
			"$2a$10$k87L/MF28Q673VKh8/cPi.SUl7MU/rWuSiIDDFayrKk/1tBsSQu4u" },
			{ "a",
			"$2a$12$8NJH3LsPrANStV6XtBakCe",
			"$2a$12$8NJH3LsPrANStV6XtBakCez0cKHXVxmvxIlcz785vxAIZrihHZpeS" },
			{ "abc",
			"$2a$06$If6bvum7DFjUnE9p2uDeDu",
			"$2a$06$If6bvum7DFjUnE9p2uDeDu0YHzrHM6tf.iqN8.yx.jNN1ILEf7h0i" },
			{ "abc",
			"$2a$08$Ro0CUfOqk6cXEKf3dyaM7O",
			"$2a$08$Ro0CUfOqk6cXEKf3dyaM7OhSCvnwM9s4wIX9JeLapehKK5YdLxKcm" },
			{ "abc",
			"$2a$10$WvvTPHKwdBJ3uk0Z37EMR.",
			"$2a$10$WvvTPHKwdBJ3uk0Z37EMR.hLA2W6N9AEBhEgrAOljy2Ae5MtaSIUi" },
			{ "abc",
			"$2a$12$EXRkfkdmXn2gzds2SSitu.",
			"$2a$12$EXRkfkdmXn2gzds2SSitu.MW9.gAVqa9eLS1//RYtYCmB1eLHg.9q" },
			{ "abcdefghijklmnopqrstuvwxyz",
			"$2a$06$.rCVZVOThsIa97pEDOxvGu",
			"$2a$06$.rCVZVOThsIa97pEDOxvGuRRgzG64bvtJ0938xuqzv18d3ZpQhstC" },
			{ "abcdefghijklmnopqrstuvwxyz",
			"$2a$08$aTsUwsyowQuzRrDqFflhge",
			"$2a$08$aTsUwsyowQuzRrDqFflhgekJ8d9/7Z3GV3UcgvzQW3J5zMyrTvlz." },
			{ "abcdefghijklmnopqrstuvwxyz",
			"$2a$10$fVH8e28OQRj9tqiDXs1e1u",
			"$2a$10$fVH8e28OQRj9tqiDXs1e1uxpsjN0c7II7YPKXua2NAKYvM6iQk7dq" },
			{ "abcdefghijklmnopqrstuvwxyz",
			"$2a$12$D4G5f18o7aMMfwasBL7Gpu",
			"$2a$12$D4G5f18o7aMMfwasBL7GpuQWuP3pkrZrOAnqP.bmezbMng.QwJ/pG" },
			{ "~!@#$%^&*()      ~!@#$%^&*()PNBFRD",
			"$2a$06$fPIsBO8qRqkjj273rfaOI.",
			"$2a$06$fPIsBO8qRqkjj273rfaOI.HtSV9jLDpTbZn782DC6/t7qT67P6FfO" },
			{ "~!@#$%^&*()      ~!@#$%^&*()PNBFRD",
			"$2a$08$Eq2r4G/76Wv39MzSX262hu",
			"$2a$08$Eq2r4G/76Wv39MzSX262huzPz612MZiYHVUJe/OcOql2jo4.9UxTW" },
			{ "~!@#$%^&*()      ~!@#$%^&*()PNBFRD",
			"$2a$10$LgfYWkbzEvQ4JakH7rOvHe",
			"$2a$10$LgfYWkbzEvQ4JakH7rOvHe0y8pHKF9OaFgwUZ2q7W2FFZmZzJYlfS" },
			{ "~!@#$%^&*()      ~!@#$%^&*()PNBFRD",
			"$2a$12$WApznUOJfkEGSmYRfnkrPO",
			"$2a$12$WApznUOJfkEGSmYRfnkrPOr466oFDCaj4b6HY3EXGvfxm43seyhgC" },
		};

//	/**
//	 * Entry point for unit tests
//	 * @param args unused
//	 */
//	public static void main(String[] args) {
//		junit.textui.TestRunner.run(BCryptTest.class);
//	}

	/**
	 * Test method for 'BCrypt.hashpw(String, String)'
	 */
	@Test
	public void testHashpw() {
		System.out.print("BCrypt.hashpw(): ");
		for (int i = 0; i < test_vectors.length; i++) {
			String plain = test_vectors[i][0];
			String salt = test_vectors[i][1];
			String expected = test_vectors[i][2];
			String hashed = BCrypt.hashpw(plain, salt);
			assertEquals(hashed, expected);
			System.out.print(".");
		}
		System.out.println("");
	}

	/**
	 * Test method for 'BCrypt.gensalt(int)'
	 */
	@Test
	public void testGensaltInt() {
		System.out.print("BCrypt.gensalt(log_rounds):");
		for (int i = 4; i <= 12; i++) {
			System.out.print(" " + Integer.toString(i) + ":");
			for (int j = 0; j < test_vectors.length; j += 4) {
				String plain = test_vectors[j][0];
				String salt = BCrypt.gensalt(i);
				String hashed1 = BCrypt.hashpw(plain, salt);
				String hashed2 = BCrypt.hashpw(plain, hashed1);
				assertEquals(hashed1, hashed2);
				System.out.print(".");
			}
		}
		System.out.println("");
	}

	/**
	 * Test method for 'BCrypt.gensalt()'
	 */
	@Test
	public void testGensalt() {
		System.out.print("BCrypt.gensalt(): ");
		for (int i = 0; i < test_vectors.length; i += 4) {
			String plain = test_vectors[i][0];
			String salt = BCrypt.gensalt();
			String hashed1 = BCrypt.hashpw(plain, salt);
			String hashed2 = BCrypt.hashpw(plain, hashed1);
			assertEquals(hashed1, hashed2);
			System.out.print(".");
		}
		System.out.println("");
	}

	/**
	 * Test method for 'BCrypt.checkpw(String, String)'
	 * expecting success
	 */
	@Test
	public void testCheckpw_success() {
		System.out.print("BCrypt.checkpw w/ good passwords: ");
		for (int i = 0; i < test_vectors.length; i++) {
			String plain = test_vectors[i][0];
			String expected = test_vectors[i][2];
			assertTrue(BCrypt.checkpw(plain, expected));
			System.out.print(".");
		}
		System.out.println("");
	}

	/**
	 * Test method for 'BCrypt.checkpw(String, String)'
	 * expecting failure
	 */
	@Test
	public void testCheckpw_failure() {
		System.out.print("BCrypt.checkpw w/ bad passwords: ");
		for (int i = 0; i < test_vectors.length; i++) {
			int broken_index = (i + 4) % test_vectors.length;
			String plain = test_vectors[i][0];
			String expected = test_vectors[broken_index][2];
			assertFalse(BCrypt.checkpw(plain, expected));
			System.out.print(".");
		}
		System.out.println("");
	}

	/**
	 * Test for correct hashing of non-US-ASCII passwords
	 */
	@Test
	public void testInternationalChars() {
		System.out.print("BCrypt.hashpw w/ international chars: ");
		String pw1 = "Ï€Ï€Ï€Ï€Ï€Ï€Ï€Ï€";
		String pw2 = "????????";

		String h1 = BCrypt.hashpw(pw1, BCrypt.gensalt());
		assertFalse(BCrypt.checkpw(pw2, h1));
		System.out.print(".");

		String h2 = BCrypt.hashpw(pw2, BCrypt.gensalt());
		assertFalse(BCrypt.checkpw(pw1, h2));
		System.out.print(".");
		System.out.println("");
	}

	@Test
	public void testSimplePasswords() {
		System.out.print("Test Simple Passwords: ");

		String simplePasswords[] = {"","Password1","abc123","a","ukalltheway","goBigBlu3!"};
		for (int i = 0; i < simplePasswords.length; i++) {
			runHashAndIsValidTestForVariousEncryptionRounds(simplePasswords[i]);			
		}
		
		System.out.println("");
	}

	@Test
	public void testLongPasswords() {
		System.out.print("Test Long Passwords: ");

		String longPasswords[] = {  "Noooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo!",
									"Yeaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaahhh!",
									"You'll find the grail in the castle arrgggggggggggggggggggggggggggggggghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh!"};
		for (int i = 0; i < longPasswords.length; i++) {
			runHashAndIsValidTestForVariousEncryptionRounds(longPasswords[i]);			
		}
		
		System.out.println("");
	}

	//note: had to follow these instructions to get stuff to compile on my Win7 machine: http://whatiscomingtomyhead.wordpress.com/2012/01/02/get-rid-of-unmappable-character-for-encoding-cp1252-once-and-for-all/
	@Test
	public void testSpecialCharacterPasswords() {
		System.out.print("Test Special Character Passwords: ");

		String specialCharPasswords[] = { "\t", "has a newline in it \n blah", "\0", "Åštiá¸·l trÌ¾ÍªÌ€Ì�Í˜yÌ¶Ì§Ì¨Ì±Ì¹Ì­Í§inÇ¥ to Ä¡Ä™t áµºÃª hanÍ›ÍªÌˆg of tweÍ›Í†Ì¾Í«Ì‘Í†Í–Í‰Ì©ÌŸÌ�Í«Í¥Í¨eÌ­Í¯Ì¿Ì”Í‘Ì¾Ì¾ting wÃ­tÌ¨Ì¥Ì«ÍŽh a á¸ŸoÌ—uá¶‡áº—aiá¹‹ pÒ‰Ì¯ÍˆÍ•en.", 
			"Je ne suis pas fatiguÃ©", "Il ne sera pas lÃ ", "Â¡Hola!", "Â¿Y TÃº?", "Bis spÃ¤ter!", "ã‚ˆã�†ã�“ã��ã�„ã‚‰ã�£ã�—ã‚ƒã�„ã�¾ã�—ã�Ÿ" };
		for (int i = 0; i < specialCharPasswords.length; i++) {
			runHashAndIsValidTestForVariousEncryptionRounds(specialCharPasswords[i]);			
		}
		
		System.out.println("");
	}

	@Test
	public void testPrecalculatedHashes() {
		System.out.print("Test Pre-calculated hashes: ");

		runPrecalculatedHashTest("Password1", 9, "$2a$09$CmaUTtldsNCjYXpTikhnRuNHIj5BK236TCnlohzFKtncF9xjBvUwu");
		runPrecalculatedHashTest("it's_just_a_string", 8, "$2a$08$ZBNPFt4fk4/d7NqwofJiCuS7sAQc0KbXTY4jgYo6KFFWae7IX5huW");
		runPrecalculatedHashTest("abc", 8, "$2a$08$Ro0CUfOqk6cXEKf3dyaM7OhSCvnwM9s4wIX9JeLapehKK5YdLxKcm");
		runPrecalculatedHashTest("Noooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo!", 4, "$2a$04$vgIsSb2s7cKVc9sEpCuwi.KWHwie/TzR0NgaNUAyWTp4z23pPWbZe");
		runPrecalculatedHashTest("has a newline in it \n blah", 5, "$2a$05$Pa3E9c/YzrKxBEqyluT3Z..HBqlPZs1hIuv4zIdAco.KUM1pK58R2");
//TODO		runPrecalculatedHashTest("Åštiá¸·l trÌ¾ÍªÌ€Ì�Í˜yÌ¶Ì§Ì¨Ì±Ì¹Ì­Í§inÇ¥ to Ä¡Ä™t áµºÃª hanÍ›ÍªÌˆg of tweÍ›Í†Ì¾Í«Ì‘Í†Í–Í‰Ì©ÌŸÌ�Í«Í¥Í¨eÌ­Í¯Ì¿Ì”Í‘Ì¾Ì¾ting wÃ­tÌ¨Ì¥Ì«ÍŽh a á¸ŸoÌ—uá¶‡áº—aiá¹‹ pÒ‰Ì¯ÍˆÍ•en.", 6, "$2a$06$qGxvg6.Kwax2fCmnQ5UCmOoilgXfYpoTAMZbpopjs6QOtSsnxSwDO");

		System.out.println("");
	}

	@Test
	public void testHashingTimeGrowsWithNumberOfRounds() {
		System.out.print("Test Hashing Time Grows With Cost: ");
		String plainTextPassword = java.util.UUID.randomUUID().toString();

		//run through once for each value of the cost parameter and generate a password just to eliminate startup time from the actual test
		for (int i=6; i<=10; i++) {
			BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(i));
		}

		long lasttime = 0;

		for (int i=6; i<=10; i++) {
			long before = System.currentTimeMillis();	
            BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(i));
			long after = System.currentTimeMillis();	
			long timediff = after - before;
			assertTrue(timediff > lasttime);
			lasttime = timediff;
            System.out.print(".");	
		}
		System.out.println("");  
	}

	// There is a known limitation that the BCrypt algorithm only cares about the first 72 bytes of the password
	// See: https://github.com/ncb000gt/node.bcrypt.js/blob/master/src/node_blf.h#L59
	@Test
	public void testThatDemonstratesBCryptOnlyUsesFirst72BytesOfPassword() {
		System.out.print("Test Limitations of Length of Password: ");

		String stringOf72Bytes = "___hello_i_am_72_chars_of___________________________________________data";           
		assertTrue(stringOf72Bytes.length() == 72);

		String stringOf71Bytes = "___hello_i_am_71_chars_of__________________________________________data";
		assertTrue(stringOf71Bytes.length() == 71);

		String validHashForStringWith72Bytes = "$2a$10$.z73An.eUqQFDOlKHjNMPO6rA0LqRJiFVzr753sKj9sEnvaz/Ix0K";
		String validHashForStringWith71Bytes = "$2a$10$59w/ESAcGZ1m6wsR7yYR4O.IlFDj9AO3.I.oF22rvWE1pcQ4u1o.K";

		assertTrue(BCrypt.checkpw(stringOf72Bytes, validHashForStringWith72Bytes));
		assertTrue(BCrypt.checkpw(stringOf71Bytes, validHashForStringWith71Bytes));

		//add something random to the 72 byte string and make sure it's still valid with the other hash
		assertTrue(BCrypt.checkpw(stringOf72Bytes + java.util.UUID.randomUUID().toString(), validHashForStringWith72Bytes));

		//add something random to the 71 byte string and make sure it's NOT still valid with the other hash
		assertFalse(BCrypt.checkpw(stringOf71Bytes + java.util.UUID.randomUUID().toString(), validHashForStringWith71Bytes));

		System.out.print(".");
		
		System.out.println("");
	}

	@Test
	public void testThatPreferredNumberOfRoundsRequiresAtLeastATenthOfASecond() {
		System.out.print("Test Default Cost Requires at least .1 seconds: ");
        String plainTextPassword = java.util.UUID.randomUUID().toString();
		long before = System.currentTimeMillis();	
        BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
		long after = System.currentTimeMillis();	

		long millisSpent = after - before;
		assertTrue(millisSpent >= 10);
        System.out.print(".");		
		System.out.println("");
	}

	/// <summary>
	/// helper function that
	/// 1) iterates through several different cheap cost factors
	/// 2) hashes the given plain text password
	/// 3) verifies that the given hash passes the IsValidPassword method
	/// 4) verifies the hash is exactly 60 characters long
	/// </summary>
	/// <param name="plainTextInput"></param>
	private void runHashAndIsValidTestForVariousEncryptionRounds(String plainTextInput) {
		for (int i = 4; i <= 8; i++) {                
			String hash = BCrypt.hashpw(plainTextInput, BCrypt.gensalt(i));

			assertTrue(BCrypt.checkpw(plainTextInput, hash));

			//all the hashes should be 60 characters in length.  No more, no less.  The number of the characters shall be 60.
			assertTrue(hash.length() == 60);

			System.out.print(".");
		}
	}

	private void runPrecalculatedHashTest(String plainTextInput, int cost, String hashThatShouldVerify) {
		String newHash = BCrypt.hashpw(plainTextInput, BCrypt.gensalt(cost));

		//make sure the new hash doesn't match the old one, but that both still work
		assertFalse(hashThatShouldVerify == newHash);
		assertTrue(BCrypt.checkpw(plainTextInput, hashThatShouldVerify));
		assertTrue(BCrypt.checkpw(plainTextInput, newHash));
  
		System.out.print(".");
	}

}
