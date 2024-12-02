package ParcoDivertimenti;

import java.util.Scanner;

public class ParcoDivertimentiRivisitato
{
	public static void main(String[] args)
	{//Variabili Visitatori
		double numeroVisitatori = 3;
		double numeroVisitatoriSoddisfatti = 0;
		double percentualeVisitatoriSoddisfatti = 0;
		//1
		int visitatore1Budget = 50;
		boolean visitatore1Uscito = false;
		boolean visitatore1VisitatoAttrazione = false;
		boolean visitatore1InCoda = false;
		boolean visitatore1Salito = false;
		//2
		int visitatore2Budget = 0;
		boolean visitatore2Uscito = false;
		boolean visitatore2VisitatoAttrazione = false;
		boolean visitatore2InCoda = false;
		boolean visitatore2Salito = false;
		//3
		int visitatore3Budget = 11;
		boolean visitatore3Uscito = false;
		boolean visitatore3VisitatoAttrazione = false;
		boolean visitatore3InCoda = false;
		boolean visitatore3Salito = false;
		//Variabili Attrazioni
		//1
		int attrazione1CostoBiglietto = 10;
		int attrazione1CostoOperazionale = 3;
		int attrazione1CapienzaMassima = 5;
		int attrazione1GiriMassimi = 4;
		int attrazione1TempoGiro = 3;
		int attrazione1CodaAttuale = 0;
		int attrazione1CapienzaAttuale = 5;
		double attrazione1TempoAttesa = attrazione1TempoGiro;
		int attrazione1CodaMassima = attrazione1CapienzaMassima; //C'è solo una coda perché era problematico ricordare chi fosse arrivato prima e chi dopo
		int attrazione1GiriAttuali = 0;
		int attrazione1GiriEffettuati = 0;
		int attrazione1Visita = 0;
		double attrazione1NumeroCode = 0;
		//2
		int attrazione2CostoBiglietto = 8;
		int attrazione2CostoOperazionale = 2;
		int attrazione2CapienzaMassima = 3;
		int attrazione2GiriMassimi = 5;
		int attrazione2TempoGiro = 4;
		int attrazione2CodaAttuale = 0;
		int attrazione2CapienzaAttuale = 0;
		double attrazione2TempoAttesa = attrazione2TempoGiro;
		int attrazione2CodaMassima = attrazione2CapienzaMassima; //C'è solo una coda perché era problematico ricordare chi fosse arrivato prima e chi dopo
		int attrazione2GiriAttuali = 0;
		int attrazione2GiriEffettuati = 0;
		int attrazione2Visita = 0;
		double attrazione2NumeroCode = 0;
		//Variabili ausiliarie
		int guadagnoParco = 0;
		boolean programmaFunziona = (visitatore1Uscito && visitatore2Uscito && visitatore3Uscito);
		//boolean sceltaGiostrePossibile = (visitatore1Uscito && visitatore1InCoda && visitatore1Salito) || (visitatore2Uscito && visitatore2InCoda && visitatore2Salito)|| (visitatore3Uscito && visitatore3InCoda && visitatore3Salito); //Logica sbagliata. Inoltre serve veramente?
		boolean visitatore1NonDisponibile = visitatore1Uscito || visitatore1InCoda || visitatore1Salito; //Credo sia questo il problema **** rimane false anche quando Uscito è true
		boolean visitatore2NonDisponibile = visitatore2Uscito || visitatore2InCoda || visitatore2Salito;
		boolean visitatore3NonDisponibile = visitatore3Uscito || visitatore3InCoda || visitatore3Salito;
		boolean sceltaVisitatoreNonPossibile = visitatore1NonDisponibile && visitatore2NonDisponibile && visitatore3NonDisponibile;

		Scanner scanner = new Scanner(System.in);

		//Scelta giorno della settimana
		System.out.println("Immetti il giorno della settimana con numero da 1 a 7. Attenzione il giorno 3 il parco è chiuso: ");
		int giornoSettimana = scanner.nextInt();
		while (giornoSettimana < 1 || giornoSettimana > 7)
		{
			System.out.println("Input non valido, riprovare: ");
			giornoSettimana = scanner.nextInt();
		}
		if (giornoSettimana == 3)
		{
			System.out.println("Mi dispiace il parco è chiuso.");
			System.exit(0);
		}
		int IdVisitatore = -1;
		while (programmaFunziona == false) //Finché è falso il programma deve funzionare
		{
			while (sceltaVisitatoreNonPossibile == false) //Finché è falso ci sono visitatori che possono scegliere un'attrazione o uscire dal parco
			{
				while (IdVisitatore < 1 || IdVisitatore > 4) //Check su IdVisitatore
				{
					System.out.println("Quale visitatore sta visitando? Puoi scegliere 1,2 e 3.");
					IdVisitatore = scanner.nextInt();
					switch (IdVisitatore)
					{
					case 1:
						while (IdVisitatore == 1 && (visitatore1InCoda == true || visitatore1Uscito == true || visitatore1Salito == true)) //Se vale una delle seguenti condizioni il visitaore non può più essere scelto 
						{
							if (visitatore1InCoda == true)
								System.out.println("Il visitatore è in fila. Scegli un altro visitatore. ");
							if (visitatore1Uscito == true)
								System.out.println("Il visitatore è uscito dal parco. Scegli un altro visitatore. ");
							if (visitatore1Salito == true)
								System.out.println("Il visitatore è in attesa su una giostra. Scegli un altro visitatore. ");
							IdVisitatore = -1;
						}
						break;
					case 2:
						while (IdVisitatore == 2 && (visitatore2InCoda == true || visitatore2Uscito == true || visitatore2Salito == true)) //Se vale una delle seguenti condizioni il visitaore non può più essere scelto
						{
							if (visitatore2InCoda == true)
								System.out.println("Il visitatore è in fila. Scegli un altro visitatore. ");
							if (visitatore2Uscito == true)
								System.out.println("Il visitatore è uscito dal parco. Scegli un altro visitatore. ");
							if (visitatore2Salito == true)
								System.out.println("Il visitatore è in attesa su una giostra. Scegli un altro visitatore. ");
							IdVisitatore = -1;
						}
						break;
					case 3:
						while (IdVisitatore == 3 && (visitatore3InCoda == true || visitatore3Uscito == true || visitatore3Salito == true)) //Se vale una delle seguenti condizioni il visitaore non può più essere scelto
						{
							if (visitatore3InCoda == true)
								System.out.println("Il visitatore è in fila. Scegli un altro visitatore. ");
							if (visitatore3Uscito == true)
								System.out.println("Il visitatore è uscito dal parco. Scegli un altro visitatore. ");
							if (visitatore3Salito == true)
								System.out.println("Il visitatore è in attesa su una giostra. Scegli un altro visitatore. ");
							IdVisitatore = -1;
						}
						break;
					case 4:
						sceltaVisitatoreNonPossibile = true;
						//sceltaGiostrePossibile = true;
						break;
					case 5:
						programmaFunziona = true;
						break;
					}
				}
				int IdAttrazione = -1;
				while (IdAttrazione == -1) //Se IdAttrazione == -1 il visitatore può cambiare attrazione da visitare 
				{
					while (IdAttrazione != 1 && IdAttrazione != 2 && IdAttrazione != 4) //Scelta attrazione o uscita dal parco
					{
						System.out.println("Inserisci ID attrazione da visitare. Puoi scegliere tra 1, 2 e 4. Attenzione 4 equivale a uscire: ");
						IdAttrazione = scanner.nextInt();
						switch (IdAttrazione)
						{
						case 1:
							while (IdAttrazione == 1 && (attrazione1CodaAttuale == attrazione1CodaMassima || attrazione1GiriAttuali == attrazione1GiriMassimi))
							{
								if (attrazione1CodaAttuale == attrazione1CodaMassima)
									System.out.println("L'attrazione ha la coda piena, selezionare altre: ");
								if (attrazione1GiriAttuali == attrazione1GiriMassimi)
									System.out.println("L'attrazione non può più effettuare giri, selezionare altre: ");
								IdAttrazione = -1; //Tornare alla scelta attrazione
							}
							while (IdAttrazione == 1 && IdVisitatore == 1 && visitatore1Budget < attrazione1CostoBiglietto)
							{
								System.out.println("Budget insufficiente per giro attrazione, selezionare altre: ");
								IdAttrazione = -1; //Tornare alla scelta attrazione
							}
							while (IdAttrazione == 1 && IdVisitatore == 2 && visitatore2Budget < attrazione1CostoBiglietto)
							{
								System.out.println("Budget insufficiente per giro attrazione, selezionare altre: ");
								IdAttrazione = -1; //Tornare alla scelta attrazione
							}
							while (IdAttrazione == 1 && IdVisitatore == 3 && visitatore3Budget < attrazione1CostoBiglietto)
							{
								System.out.println("Budget insufficiente per giro attrazione, selezionare altre: ");
								IdAttrazione = -1; //Tornare alla scelta attrazione
							}
							break;
						case 2:
							while (IdAttrazione == 2 && (attrazione2CodaAttuale == attrazione2CodaMassima || attrazione2GiriAttuali == attrazione2GiriMassimi))
							{
								if (attrazione2CodaAttuale == attrazione2CodaMassima)
									System.out.println("L'attrazione ha la coda piena, selezionare altre: ");
								if (attrazione2GiriAttuali == attrazione2GiriMassimi)
									System.out.println("L'attrazione non può più effettuare giri, selezionare altre: ");
								IdAttrazione = -1; //Tornare alla scelta attrazione
							}
							while (IdAttrazione == 2 && IdVisitatore == 1 && visitatore1Budget < attrazione2CostoBiglietto)
							{
								System.out.println("Budget insufficiente per giro attrazione, selezionare altre: ");
								IdAttrazione = -1; //Tornare alla scelta attrazione
							}
							while (IdAttrazione == 2 && IdVisitatore == 2 && visitatore2Budget < attrazione2CostoBiglietto)
							{
								System.out.println("Budget insufficiente per giro attrazione, selezionare altre: ");
								IdAttrazione = -1; //Tornare alla scelta attrazione
							}
							while (IdAttrazione == 2 && IdVisitatore == 3 && visitatore3Budget < attrazione2CostoBiglietto)
							{
								System.out.println("Budget insufficiente per giro attrazione, selezionare altre: ");
								IdAttrazione = -1; //Tornare alla scelta attrazione
							}
							break;
						case 4:
							switch (IdVisitatore)
							{
							case 1:
								visitatore1Uscito = true;
								visitatore1NonDisponibile = visitatore1Uscito || visitatore1InCoda || visitatore1Salito;
								sceltaVisitatoreNonPossibile = visitatore1NonDisponibile && visitatore2NonDisponibile && visitatore3NonDisponibile;
								programmaFunziona = (visitatore1Uscito && visitatore2Uscito && visitatore3Uscito);
								if (visitatore1VisitatoAttrazione == false)
								{
									System.out.println("Arrivederci");
									IdVisitatore = -1; //Tornare scelta visitatore

								} else if (visitatore1VisitatoAttrazione == true)
								{
									System.out.println("Sei rimasto soddisfatto? Scegli 1 per sì, 2 per no: ");
									int inputVisistatoreSoddisfatto = scanner.nextInt();
									while (inputVisistatoreSoddisfatto != 1 && inputVisistatoreSoddisfatto != 2)
									{
										System.out.println("Input non valido. Inserisci 1 per sì, 2 per no: ");
										inputVisistatoreSoddisfatto = scanner.nextInt();
									}
									switch (inputVisistatoreSoddisfatto)
									{
									case 1:
										numeroVisitatoriSoddisfatti++;
										System.out.println("Grazie per il feedback positivo. A presto.");
										break;
									case 2:
										System.out.println("Mi dispiace che il nostro parco non abbia soddisfatto le tue aspettative. Arrivederci.");
										break;
									}
									IdVisitatore = -1; //Tornare scelta visitatore
								}
								break;
							case 2:
								visitatore2Uscito = true;
								programmaFunziona = (visitatore1Uscito && visitatore2Uscito && visitatore3Uscito);
								visitatore2NonDisponibile = visitatore2Uscito || visitatore2InCoda || visitatore2Salito;
								sceltaVisitatoreNonPossibile = visitatore1NonDisponibile && visitatore2NonDisponibile && visitatore3NonDisponibile;
								if (visitatore2VisitatoAttrazione == false)
								{
									System.out.println("Arrivederci"); //Tornare scelta visitatore
									IdVisitatore = -1;

								} else if (visitatore2VisitatoAttrazione == true)
								{
									System.out.println("Sei rimasto soddisfatto? Scegli 1 per sì, 2 per no: ");
									int inputVisistatoreSoddisfatto = scanner.nextInt();
									while (inputVisistatoreSoddisfatto != 1 && inputVisistatoreSoddisfatto != 2)
									{
										System.out.println("Input non valido. Inserisci 1 per sì, 2 per no:");
										inputVisistatoreSoddisfatto = scanner.nextInt();
									}
									switch (inputVisistatoreSoddisfatto)
									{
									case 1:
										numeroVisitatoriSoddisfatti++;
										System.out.println("Grazie per il feedback positivo. A presto.");
										break;
									case 2:
										System.out.println("Mi dispiace che il nostro parco non abbia soddisfatto le tue aspettative. Arrivederci.");
										break;
									}
									IdVisitatore = -1; //Tornare scelta visitatore
								}
								break;
							case 3:
								visitatore3Uscito = true;
								visitatore3NonDisponibile = visitatore3Uscito || visitatore3InCoda || visitatore3Salito;
								sceltaVisitatoreNonPossibile = visitatore1NonDisponibile && visitatore2NonDisponibile && visitatore3NonDisponibile;
								programmaFunziona = (visitatore1Uscito && visitatore2Uscito && visitatore3Uscito);
								if (visitatore3VisitatoAttrazione == false)
								{
									System.out.println("Arrivederci"); //Tornare scelta visitatore
									IdVisitatore = -1;
								} else if (visitatore3VisitatoAttrazione == true)
								{
									System.out.println("Sei rimasto soddisfatto? Scegli 1 per sì, 2 per no: ");
									int inputVisistatoreSoddisfatto = scanner.nextInt();
									while (inputVisistatoreSoddisfatto != 1 && inputVisistatoreSoddisfatto != 2)
									{
										System.out.println("Input non valido. Inserisci 1 per sì, 2 per no:");
										inputVisistatoreSoddisfatto = scanner.nextInt();
									}
									switch (inputVisistatoreSoddisfatto)
									{
									case 1:
										numeroVisitatoriSoddisfatti++;
										System.out.println("Grazie per il feedback positivo. A presto.");
										break;
									case 2:
										System.out.println("Mi dispiace che il nostro parco non abbia soddisfatto le tue aspettative. Arrivederci.");
										break;
									}
									IdVisitatore = -1; //Tornare scelta visitatore
								}
								break;
							}
							break;
						}
					}
					System.out.println("Dopo scelta attrazione");

					//Conferma Attrazione
					switch (IdAttrazione)
					{
					case 1:
						switch (IdVisitatore)
						{
						case 1:
							if (attrazione1CapienzaAttuale < attrazione1CapienzaMassima && attrazione1CapienzaAttuale > -1)
							{
								System.out.println("Non c'è tempo di attesa, il visitatore sale sulla giostra. ");
								attrazione1CapienzaAttuale++; //Il visitatore sale sulla giostra
								visitatore1VisitatoAttrazione = true;
								visitatore1Budget -= attrazione1CostoBiglietto;
								visitatore1Salito = true;
								visitatore1NonDisponibile = visitatore1Uscito || visitatore1InCoda || visitatore1Salito;
								sceltaVisitatoreNonPossibile = visitatore1NonDisponibile && visitatore2NonDisponibile && visitatore3NonDisponibile;
								attrazione1Visita++;
								IdAttrazione = -1;
								IdVisitatore = -1; // Tornare scelta visitatore
								break;
							} else
							{
								System.out.println("Il tempo di attesa è: " + attrazione1TempoAttesa);
								System.out.println("Confermi la scelta? Premere 1 per sì, premere 2 per no.");
								int confermaScelta = -1;
								while (confermaScelta != 1 && confermaScelta != 2)
								{
									confermaScelta = scanner.nextInt();

									switch (confermaScelta)
									{
									case 1:
										if (attrazione1CodaAttuale < attrazione1CodaMassima)
										{
											System.out.println("Il visitatore si è messo in coda.");
											attrazione1CodaAttuale++;
											visitatore1InCoda = true;
											visitatore1NonDisponibile = visitatore1Uscito || visitatore1InCoda || visitatore1Salito;
											sceltaVisitatoreNonPossibile = visitatore1NonDisponibile && visitatore2NonDisponibile && visitatore3NonDisponibile;
											attrazione1Visita++;
											visitatore1Budget -= attrazione1CostoBiglietto;
											IdVisitatore = -1;
										} else
										{
											System.out.println("La coda è piena, per favore scegli un'altra attrazione.");
											continue; //Tornare a scelta attrazione
										}
										break;
									case 2:
										//Tornare a scelta attrazione
										System.out.println("Caso 2");
										continue;
									default:
										System.out.println("Input non valido, premere 1 o 2");
										break;
									}
								}
							}
							break;
						case 2:
							if (attrazione1CapienzaAttuale < attrazione1CapienzaMassima && attrazione1CapienzaAttuale > -1)
							{
								System.out.println("Non c'è tempo di attesa, il visitatore sale sulla giostra. ");
								attrazione1CapienzaAttuale++; //Il visitatore sale sulla giostra
								visitatore2VisitatoAttrazione = true;
								visitatore2Budget -= attrazione1CostoBiglietto;
								visitatore2Salito = true;
								visitatore2NonDisponibile = visitatore2Uscito || visitatore2InCoda || visitatore2Salito;
								sceltaVisitatoreNonPossibile = visitatore1NonDisponibile && visitatore2NonDisponibile && visitatore3NonDisponibile;
								attrazione1Visita++;
								IdAttrazione = -1;
								IdVisitatore = -1; // Tornare scelta visitatore
								break;
							} else
							{
								System.out.println("Il tempo di attesa è: " + attrazione1TempoAttesa);
								System.out.println("Confermi la scelta? Premere 1 per sì, premere 2 per no.");
								int confermaScelta = -1;
								while (confermaScelta != 1 && confermaScelta != 2)
								{
									confermaScelta = scanner.nextInt();

									switch (confermaScelta)
									{
									case 1:
										if (attrazione1CodaAttuale < attrazione1CodaMassima)
										{
											System.out.println("Il visitatore si è messo in coda.");
											attrazione1CodaAttuale++;
											visitatore2InCoda = true;
											visitatore2NonDisponibile = visitatore2Uscito || visitatore2InCoda || visitatore2Salito;
											sceltaVisitatoreNonPossibile = visitatore1NonDisponibile && visitatore2NonDisponibile && visitatore3NonDisponibile;
											attrazione1Visita++;
											visitatore2Budget -= attrazione1CostoBiglietto;
											IdVisitatore = -1;
										} else
										{
											System.out.println("La coda è piena, per favore scegli un'altra attrazione.");
											continue; //Tornare a scelta attrazione
										}
										break;
									case 2:
										//Tornare a scelta attrazione
										System.out.println("Caso 2");
										continue;
									default:
										System.out.println("Input non valido, premere 1 o 2");
										break;
									}
								}
							}
							break;
						case 3:
							if (attrazione1CapienzaAttuale < attrazione1CapienzaMassima && attrazione1CapienzaAttuale > -1)
							{
								System.out.println("Non c'è tempo di attesa, il visitatore sale sulla giostra. ");
								attrazione1CapienzaAttuale++; //Il visitatore sale sulla giostra
								visitatore3VisitatoAttrazione = true;
								visitatore3Budget -= attrazione1CostoBiglietto;
								visitatore3Salito = true;
								visitatore3NonDisponibile = visitatore3Uscito || visitatore3InCoda || visitatore3Salito;
								sceltaVisitatoreNonPossibile = visitatore1NonDisponibile && visitatore2NonDisponibile && visitatore3NonDisponibile;
								attrazione1Visita++;
								IdAttrazione = -1;
								IdVisitatore = -1; // Tornare scelta visitatore
								break;
							} else
							{
								System.out.println("Il tempo di attesa è: " + attrazione1TempoAttesa);
								System.out.println("Confermi la scelta? Premere 1 per sì, premere 2 per no.");
								int confermaScelta = -1;
								while (confermaScelta != 1 && confermaScelta != 2)
								{
									confermaScelta = scanner.nextInt();

									switch (confermaScelta)
									{
									case 1:
										if (attrazione1CodaAttuale < attrazione1CodaMassima)
										{
											System.out.println("Il visitatore si è messo in coda.");
											attrazione1CodaAttuale++;
											visitatore3InCoda = true;
											visitatore3NonDisponibile = visitatore3Uscito || visitatore3InCoda || visitatore3Salito;
											sceltaVisitatoreNonPossibile = visitatore1NonDisponibile && visitatore2NonDisponibile && visitatore3NonDisponibile;
											attrazione1Visita++;
											visitatore3Budget -= attrazione1CostoBiglietto;
											IdVisitatore = -1;
										} else
										{
											System.out.println("La coda è piena, per favore scegli un'altra attrazione.");
											continue; //Tornare a scelta attrazione
										}
										break;
									case 2:
										//Tornare a scelta attrazione
										System.out.println("Caso 2");
										continue;
									default:
										System.out.println("Input non valido, premere 1 o 2");
										break;
									}
								}
							}
							break;
						default:
							System.out.println("Debug 1");
							break;
						}
						break;
					case 2:
						switch (IdVisitatore)
						{
						case 1:
							if (attrazione2CapienzaAttuale < attrazione2CapienzaMassima && attrazione2CapienzaAttuale > -1)
							{
								System.out.println("Non c'è tempo di attesa, il visitatore sale sulla giostra. ");
								attrazione2CapienzaAttuale++; //Il visitatore sale sulla giostra
								visitatore1VisitatoAttrazione = true;
								visitatore1Budget -= attrazione2CostoBiglietto;
								visitatore1Salito = true;
								visitatore1NonDisponibile = visitatore1Uscito || visitatore1InCoda || visitatore1Salito;
								sceltaVisitatoreNonPossibile = visitatore1NonDisponibile && visitatore2NonDisponibile && visitatore3NonDisponibile;
								attrazione2Visita++;
								IdAttrazione = -1;
								IdVisitatore = -1;
								break;
							} else
							{
								System.out.println("Il tempo di attesa è: " + attrazione2TempoAttesa);
								System.out.println("Confermi la scelta? Premere 1 per sì, premere 2 per no.");
								int confermaScelta = -1;
								while (confermaScelta != 1 && confermaScelta != 2)
								{
									confermaScelta = scanner.nextInt();

									switch (confermaScelta)
									{
									case 1:
										if (attrazione2CodaAttuale < attrazione2CodaMassima)
										{
											System.out.println("Il visitatore si è messo in coda.");
											attrazione2CodaAttuale++;
											visitatore1InCoda = true;
											visitatore1NonDisponibile = visitatore1Uscito || visitatore1InCoda || visitatore1Salito;
											sceltaVisitatoreNonPossibile = visitatore1NonDisponibile && visitatore2NonDisponibile && visitatore3NonDisponibile;
											attrazione2Visita++;
											visitatore1Budget -= attrazione2CostoBiglietto;
											IdVisitatore = -1;
										} else
										{
											System.out.println("La coda è piena, per favore scegli un'altra attrazione.");
											continue; //Tornare a scelta attrazione
										}
										break;
									case 2:
										//Tornare a scelta attrazione
										System.out.println("Caso 2");
										continue;
									default:
										System.out.println("Input non valido, premere 1 o 2");
										break;
									}
								}
							}
							break;
						case 2:
							if (attrazione2CapienzaAttuale < attrazione2CapienzaMassima && attrazione2CapienzaAttuale > -1)
							{
								System.out.println("Non c'è tempo di attesa, il visitatore sale sulla giostra. ");
								attrazione2CapienzaAttuale++; //Il visitatore sale sulla giostra
								visitatore2VisitatoAttrazione = true;
								visitatore2Budget -= attrazione2CostoBiglietto;
								visitatore2Salito = true;
								visitatore2NonDisponibile = visitatore2Uscito || visitatore2InCoda || visitatore2Salito;
								sceltaVisitatoreNonPossibile = visitatore1NonDisponibile && visitatore2NonDisponibile && visitatore3NonDisponibile;
								attrazione2Visita++;
								IdAttrazione = -1;
								IdVisitatore = -1; // Tornare scelta visitatore
								break;
							} else
							{
								System.out.println("Il tempo di attesa è: " + attrazione2TempoAttesa);
								System.out.println("Confermi la scelta? Premere 1 per sì, premere 2 per no.");
								int confermaScelta = -1;
								while (confermaScelta != 1 && confermaScelta != 2)
								{
									confermaScelta = scanner.nextInt();

									switch (confermaScelta)
									{
									case 1:
										if (attrazione2CodaAttuale < attrazione2CodaMassima)
										{
											System.out.println("Il visitatore si è messo in coda.");
											attrazione2CodaAttuale++;
											visitatore2InCoda = true;
											visitatore2NonDisponibile = visitatore2Uscito || visitatore2InCoda || visitatore2Salito;
											sceltaVisitatoreNonPossibile = visitatore1NonDisponibile && visitatore2NonDisponibile && visitatore3NonDisponibile;
											attrazione2Visita++;
											visitatore2Budget -= attrazione2CostoBiglietto;
											IdVisitatore = -1;
										} else
										{
											System.out.println("La coda è piena, per favore scegli un'altra attrazione.");
											continue; //Tornare a scelta attrazione
										}
										break;
									case 2:
										//Tornare a scelta attrazione
										System.out.println("Caso 2");
										continue;
									default:
										System.out.println("Input non valido, premere 1 o 2");
										break;
									}
								}
							}
							break;
						case 3:
							if (attrazione2CapienzaAttuale < attrazione2CapienzaMassima && attrazione2CapienzaAttuale > -1)
							{
								System.out.println("Non c'è tempo di attesa, il visitatore sale sulla giostra. ");
								attrazione2CapienzaAttuale++; //Il visitatore sale sulla giostra
								visitatore3VisitatoAttrazione = true;
								visitatore3Budget -= attrazione2CostoBiglietto;
								visitatore3Salito = true;
								visitatore3NonDisponibile = visitatore3Uscito || visitatore3InCoda || visitatore3Salito;
								sceltaVisitatoreNonPossibile = visitatore1NonDisponibile && visitatore2NonDisponibile && visitatore3NonDisponibile;
								attrazione2Visita++;
								IdAttrazione = -1;
								IdVisitatore = -1; // Tornare scelta visitatore
								break;
							} else
							{
								System.out.println("Il tempo di attesa è: " + attrazione2TempoAttesa);
								System.out.println("Confermi la scelta? Premere 1 per sì, premere 2 per no.");
								int confermaScelta = -1;
								while (confermaScelta != 1 && confermaScelta != 2)
								{
									confermaScelta = scanner.nextInt();

									switch (confermaScelta)
									{
									case 1:
										if (attrazione2CodaAttuale < attrazione2CodaMassima)
										{
											System.out.println("Il visitatore si è messo in coda.");
											attrazione2CodaAttuale++;
											visitatore3InCoda = true;
											visitatore3NonDisponibile = visitatore3Uscito || visitatore3InCoda || visitatore3Salito;
											sceltaVisitatoreNonPossibile = visitatore1NonDisponibile && visitatore2NonDisponibile && visitatore3NonDisponibile;
											attrazione2Visita++;
											visitatore3Budget -= attrazione2CostoBiglietto;
											IdVisitatore = -1;
										} else
										{
											System.out.println("La coda è piena, per favore scegli un'altra attrazione.");
											continue; //Tornare a scelta attrazione
										}
										break;
									case 2:
										//Tornare a scelta attrazione
										System.out.println("Caso 2");
										continue;
									default:
										System.out.println("Input non valido, premere 1 per sì o 2 per no.");
										break;
									}
								}
							}
							break;
						default:
							System.out.println("Debug 2");
						}
						break;
					}
					System.out.println("Fuori if Attrazione");
					if (IdVisitatore == -1)
						break; //Per ricreare problema premere 1 1 4 1 2
				}
				System.out.println("Fuori while sceltaGiostrePossibile: scelta e conferma attrazione o uscita parco.");
			}  //*********
			System.out.println("Fuori Scelta Visitatore");

			//Aggiornamento Attrazioni
			System.out.println("Le giostre entrano in funzione.");

			if (attrazione1CapienzaAttuale > 0 && attrazione1GiriEffettuati < attrazione1GiriMassimi)
			{
				if (attrazione1CodaAttuale > 0)
					attrazione1NumeroCode++;
				attrazione1GiriEffettuati++;
				attrazione1CapienzaAttuale = attrazione1CodaAttuale;
			}
			if (attrazione2CapienzaAttuale > 0 && attrazione2GiriEffettuati < attrazione2GiriMassimi)
			{
				if (attrazione2CodaAttuale > 0)
					attrazione2NumeroCode++;
				attrazione2GiriEffettuati++;
				attrazione2CapienzaAttuale = attrazione2CodaAttuale;
			}

			//Reset Variabili
			if (visitatore1Uscito == false)
			{
				if (visitatore1Salito == true)
					visitatore1Salito = false;
				if (visitatore1InCoda == true)
				{
					visitatore1Salito = true;
					visitatore1InCoda = false;
					visitatore1VisitatoAttrazione = true;
				}
			}
			if (visitatore2Uscito == false)
			{
				if (visitatore2Salito == true)
					visitatore2Salito = false;
				if (visitatore2InCoda == true)
				{
					visitatore2Salito = true;
					visitatore2InCoda = false;
					visitatore2VisitatoAttrazione = true;
				}
			}
			if (visitatore3Uscito == false)
			{
				if (visitatore3Salito == true)
					visitatore3Salito = false;
				if (visitatore3InCoda == true)
				{
					visitatore3Salito = true;
					visitatore3InCoda = false;
					visitatore3VisitatoAttrazione = true;
				}
			}
			attrazione1CodaAttuale = 0;
			attrazione2CodaAttuale = 0;
			//Da togliere
			sceltaVisitatoreNonPossibile = false;
			IdVisitatore = -1;

		}
		System.out.println("Fuori while programmaFunzionante, ciclo generale del programma.");

		//Statistiche
		percentualeVisitatoriSoddisfatti = numeroVisitatoriSoddisfatti / numeroVisitatori * 100;
		guadagnoParco = (attrazione1CostoBiglietto * attrazione1Visita - attrazione1CostoOperazionale) * attrazione1GiriEffettuati
				+ (attrazione2CostoBiglietto * attrazione2Visita - attrazione2CostoOperazionale) * attrazione2GiriEffettuati;
		System.out.println("La percentuale dei visitatori soddisfatti è: " + percentualeVisitatoriSoddisfatti);
		if (attrazione1Visita > attrazione2Visita)
			System.out.println("La prima attrazione è popolare.");
		else if (attrazione1Visita < attrazione2Visita)
			System.out.println("La seconda attrazione è popolare.");
		else
			System.out.println("Entrambe le attrazioni sono state visitate lo stesso numero di volte");
		double attrazione1TempoMedio = attrazione1TempoAttesa / attrazione1NumeroCode;
		double attrazione2TempoMedio = attrazione2TempoAttesa / attrazione2NumeroCode;
		if (attrazione1NumeroCode > 0)
			System.out.println("Il tempo medio di attesa per l'attrazione 1 è stato: " + attrazione1TempoMedio);
		else
			System.out.println("Il tempo medio di attesa per l'attrazione 1 è stato: 0 ");

		if (attrazione2NumeroCode > 0)
			System.out.println("Il tempo medio di attesa per l'attrazione 2 è stato: " + attrazione2TempoMedio);
		else
			System.out.println("Il tempo medio di attesa per l'attrazione 2 è stato: 0 ");

		System.out.println("Il guadagno netto in questa giornata è stato: " + guadagnoParco);
		scanner.close();
		System.exit(0);
	}

}
