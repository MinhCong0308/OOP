package AimsProject.hust.soict.globalict.aims;
import AimsProject.hust.soict.globalict.aims.cart.Cart;
import AimsProject.hust.soict.globalict.aims.media.*;
import AimsProject.hust.soict.globalict.aims.store.Store;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Aims {	
	public static void addToStore(Store store) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addItem(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addItem(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addItem(dvd3);
		
		List <String> author1 = new ArrayList<String>();
		author1.add("Munwind");
		author1.add("Lehau");
		
		List <String> author2 = new ArrayList<String>();
		author2.add("Minh");
		author2.add("Kien");
		
		Book book1 = new Book("Munwind finds his first love", "No real", 99.99f, author1);
		store.addItem(book1);
		Book book2 = new Book("We are ones", "The Hunt", 1.1f, author2);
		store.addItem(book2);
		
	}
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		Store store = new Store();
		addToStore(store);
		Cart cart = new Cart();
		int menuChoice = -1;
		while(menuChoice != 0) {
			showMenu();
			try {
				menuChoice = scanner.nextInt();
				scanner.nextLine();
			} catch(Exception e) {
				System.out.println("Unvalid value, please enter valid value(0-3): ");
				scanner.nextLine();
			}
			switch(menuChoice) {
				case 1: // View store menu
					int storeChoice = -1;
					while(storeChoice != 0) {
						storeMenu();
						try {
							storeChoice = scanner.nextInt();
							scanner.nextLine();
						} catch(Exception e) {
							System.out.println("Unvalid value, please enter valid value(0-4): ");
							scanner.nextLine();
						}
						switch(storeChoice) { 
							case 1: //Media detail
								int mediaDetailChoice = -1;
								while(mediaDetailChoice != 0) {
									mediaDetailsMenu();
									try {
										mediaDetailChoice = scanner.nextInt();
										scanner.nextLine();
									} catch(Exception e) {
										System.out.println("Unvalid value, please enter valid value(0-2): ");
									}
									switch(mediaDetailChoice) {
										case 1:
											System.out.println("Please enter the title of media: ");
											String title_item = scanner.nextLine();
											int isFound = 0;
											Media item1 = store.searchByTitle(title_item);
											if(item1 != null) isFound = 1;
											if(isFound == 1) {
												cart.addMedia(item1);
											}
											else {
												System.out.println("The item " + title_item + "does not exist in store");
											}
											break;
										case 2: //play the media item
											System.out.println("Please enter the title of media: ");
											String title_item2 = scanner.nextLine();
											int isFound2 = 0;
											Media itemPlayed = store.searchByTitle(title_item2);
											if(itemPlayed != null) isFound2 = 1;
											if(isFound2 == 0) {
												System.out.println("The item you want to play does not exist");
											}
											else {
												if(itemPlayed instanceof DigitalVideoDisc dvd) {
													((DigitalVideoDisc) itemPlayed).play();
												}
												else if (itemPlayed instanceof CompactDisc cd) {
													((CompactDisc) itemPlayed).play();
												}
												else {
													System.out.println("This type of media does not suitable to play");
												}
											}
											break;
										case 0:
											System.out.println("Back");
											break;
											
									}
								}
								break;
							case 2: //add media to cart
								int isFound2 = 0;
								System.out.println("Please enter title: ");
								String title_item2 = scanner.nextLine();
								Media item2 = store.searchByTitle(title_item2);
								if(item2 != null) isFound2 = 1; 
								if(isFound2 == 1) {
									cart.addMedia(item2);
								}
								else {
									System.out.println("The item " + title_item2 + "does not exist in store");
								}
								break;
							case 3:
								System.out.println("Please enter the title: ");
								String title_item3 = scanner.nextLine();
								Media item3 = store.searchByTitle(title_item3);
								if(item3 != null) {
									if(item3 instanceof DigitalVideoDisc dvd) {
										((DigitalVideoDisc) item3).play();
									}
									if(item3 instanceof CompactDisc cd) {
										((CompactDisc) item3).play();
									}
								}
								else {
									System.out.println("The item you want to play does not exist.");
								}
								break;
							case 4:
								cart.printCartInfor();
								break;
							case 0:
								System.out.println("Back");
								break;
						}
					}
					break;
				case 2: 
					int updateChoice = -1;
					while(updateChoice != 0) {
						updateStore();
						try {
							updateChoice = scanner.nextInt();
							scanner.nextLine();
						} catch(Exception e) {
							System.out.println("Unvalid value, please enter valid value(0-2): ");
							scanner.nextLine();
						}
						switch(updateChoice) {
							case 1: //Adding Item to Store
								int type = -1;
								while(type != 0) {
									chooseTypeOfMedia();
									try {
										type = scanner.nextInt();
										scanner.nextLine();
									} catch(Exception e) {
										System.out.println("Unvalid value, please enter valid value(0-3): ");
										scanner.nextLine();
									}
									switch(type) {
										case 1: //DVD, need title, cost
											String title_DVD;
											System.out.println("Please enter title: ");
											title_DVD = scanner.nextLine();
											Media check_DVDexisted = store.searchByTitle(title_DVD);
											if(check_DVDexisted == null) { //if DVD does not exist in store.
												float cost_DVD;
												System.out.println("Please enter cost: ");
												cost_DVD = scanner.nextFloat();
												DigitalVideoDisc dvd_add = new DigitalVideoDisc(title_DVD, cost_DVD);
												store.addItem(dvd_add);
											}
											else {
												System.out.println("This item " + title_DVD + " existed in store");
											}
											break;
										case 2: //CD, need title, category, artist, cost
											String title_CD;
											System.out.println("Please enter title: ");
											title_CD = scanner.nextLine();
											Media check_CDexisted = store.searchByTitle(title_CD);
											if(check_CDexisted == null) { //if DVD does not exist in store.
												String category;
												String artist;
												float cost_CD;
												System.out.println("Please enter category: ");
												category = scanner.nextLine();
												System.out.println("Please enter cost: ");
												cost_CD = scanner.nextFloat();
												scanner.nextLine();
												System.out.println("Please enter artist: ");
												artist = scanner.nextLine();
												CompactDisc dvd_add = new CompactDisc(title_CD, category, artist,cost_CD);
												store.addItem(dvd_add);
											}
											else {
												System.out.println("This item " + title_CD + " existed in store");
											}
											break;
										case 3: //Book, need title, category, cost
											String book_Title;
											System.out.println("Please enter title: ");
											book_Title = scanner.nextLine();
											if(store.searchByTitle(book_Title) == null) { //if book does not exist in store
												System.out.println("Please enter category: ");
												String book_Category = scanner.nextLine();
												System.out.println("Please enter cost: ");
												float cost_Book = scanner.nextFloat();
												scanner.nextLine();
												Book book_Added = new Book(book_Title, book_Category, cost_Book);
												store.addItem(book_Added);
											}
											else {
												System.out.println("This item " + book_Title + " existed in store");
											}
											break;
										case 0:
											System.out.println("Back");
											break;
									}
								}
							case 2: // Removing Item from store
								System.out.println("Please enter the title of item: ");
								String title_remove = scanner.nextLine();
								Media item_remove = store.searchByTitle(title_remove);
								if(item_remove == null) { // item_add does not exist 
									System.out.println("The item you want to remove does not exist");
								}
								else {
									store.removeItem(item_remove);
								}
								break;
							case 0:
								System.out.println("Back");
								break;
						}
					}
					break;
				case 3: 
					int cartChoice = -1;
					while(cartChoice != 0) {
						cartMenu();
						try {
							cartChoice = scanner.nextInt();
							scanner.nextLine();
						} catch(Exception e) {
							System.out.println("Unvalid value, please enter valid value(0-5): ");
							scanner.nextLine();
						}
						switch(cartChoice) {
							case 1: //Filter Media
								System.out.println("Enter title: ");
								String strToInput = scanner.nextLine();
								cart.searchByTitle(strToInput);
								break;
							case 2:
								int chooseSort = -1;
								while(chooseSort != 0) {
									chooseSorting();
									try {
										chooseSort = scanner.nextInt();
										scanner.nextLine();
									} catch(Exception e) {
										System.out.println("Unvalid value, please enter valid value(0-2): ");
										scanner.nextLine();
									}
									switch(chooseSort) {
										case 1: //sort by title
											cart.sortByTitle();
											cart.printCartInfor();
											break;
										case 2: //sort by cost
											cart.sortByCost();
											cart.printCartInfor();
											break;
										case 0:
											break;
									}
								}
								break;
							case 3: //Remove media from cart
								System.out.println("Enter the title you want deleted: ");
								String title_Removed = scanner.nextLine();
								Media checkProd_existed = cart.searchByTitle(title_Removed);
								if(checkProd_existed == null) { //does not exist in store.
									System.out.println("This item does not exist in store");
								}
								else {
									cart.removeMedia(checkProd_existed);
								}
								break;
							case 4: //play media
								System.out.print("Please enter title: ");
								String play_Title = scanner.nextLine();	
								Media play_Media = cart.searchByTitle(play_Title);
								if(play_Media == null) {
									System.out.println("Does not exist");
								}
								else {
									if(play_Media instanceof DigitalVideoDisc dvd) {
										((DigitalVideoDisc) play_Media).play();
									}
									else if(play_Media instanceof CompactDisc cd) {
										((CompactDisc) play_Media).play();
									}
									else {
										System.out.println("Book is not suitable to play");
									}
								}
								break;
							case 5: //This method will delete current cart, move it to payment part.
								System.out.println("Your ordered has been created successfully");
								cart = new Cart();
								break;
							case 0: break;
						}
					}
					break;
				case 0:
					System.out.println("Bye and have a good day");
					scanner.close();
					break;
				
			}
		}
	}
	public static void showMenu() { 
		System.out.println("AIMS: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. View store"); 
		System.out.println("2. Update store"); 
		System.out.println("3. See current cart"); 
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3"); 
	}
	public static void storeMenu() { 
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. See a media’s details"); 
		System.out.println("2. Add a media to cart"); 
		System.out.println("3. Play a media"); 
		System.out.println("4. See current cart"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4"); 
	}
	public static void mediaDetailsMenu() { 
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Add to cart"); 
		System.out.println("2. Play"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2"); 
	}
	public static void cartMenu() { 
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Filter media in cart"); 
		System.out.println("2. Sort media in cart"); 
		System.out.println("3. Remove media from cart"); 
		System.out.println("4. Play a media"); 
		System.out.println("5. Place order"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4-5"); 
	} 
	public static void updateStore() {
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Add item to store"); 
		System.out.println("2. Remove item from store"); 
		System.out.println("0. Back");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	public static void chooseTypeOfMedia() {
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. DVD"); 
		System.out.println("2. CD"); 
		System.out.println("3. Book");
		System.out.println("0. Back");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	public static void chooseSorting() {
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Sort by Title"); 
		System.out.println("2. Sort by Cost"); 
		System.out.println("0. Back");
		System.out.println("Please choose a number: 0-1-2");
	}
}
