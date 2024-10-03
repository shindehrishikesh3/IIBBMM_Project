@mob @mobvisual
Feature: Visual validation on different pages

	@homepage @Sprint72 @SRE115 @live
	Scenario Outline: Visual test for homepage in "<store>"
		Given user navigate to "<store>" store homepage and "does" accept the cookies
		When customer accesses the website as "guest" user
		And create folder structure for base & resultant images
		And I wait for "3" seconds
		Then customer visually compare "viewport" image with the baseline "<image>"
		And  refresh browser
		And I wait for "3" seconds
		Then customer visually compare "full" image with the baseline "<image>"
		But skip if baseline image captured

		@eu
		Examples:
			| store | image        |
			| uk    | ukhomepage   |
			| de    | dehomepage   |
			| cz    | czhompage    |
			| hu    | huhomepage   |
			| dk    | dkhomepahe   |
			| en-DE | endehomepage |
			| fr-BE | frbehomepage |
		@apac
		Examples:
			| store | image      |
			| hk    | hkhomepage |
			| cn    | cnhompage  |
			| tw    | twhomepage |
			| sg    | sghomepahe |
		@nwk
		Examples:
			| store  | image      |
			| us     | hkhomepage |
			| mexico | mxhompage  |
			| canada | cahomepage |

	@searchpages @Sprint72 @SRE115 @l0 @l1 @l2 @l3 @live
	Scenario Outline: Visual test for L0 L1 L2 category Node page in "<store>"
		Given user navigate to "<store>" store homepage and "does" accept the cookies
		When customer accesses the website as "guest" user
		And create folder structure for base & resultant images
		And I navigate to "<categoryPage>" page
		And I wait for "5" seconds
		Then customer visually compare "viewport" image with the baseline "<image>"
		Then customer visually compare "full" image with the baseline "<image>"
		But skip if baseline image captured
		@eu
		Examples:
			| store | categoryPage                                                                                                    | Level | image                |
			| uk    | c/audio-visual                                                                                                  | L0    | mob_audioVisual      |
			| uk    | c/automation-process-control                                                                                    | L0    | autoprocesscontrol   |
			| uk    | c/batteries-chargers                                                                                            | L0    | batt                 |
			| uk    | c/cable-wire-cable-assemblies                                                                                   | L0    | cable-wire-a         |
			| es    | c/cables-conjuntos-de-cables                                                                                    | L0    | cables               |
			| uk    | c/office-computer-networking-products/computer-products                                                         | L1    | computerProducts     |
			| uk    | c/optoelectronics-displays/displays                                                                             | L1    | displays             |
			| ie    | c/engineering-software/compilers-ides                                                                           | L1    | compilers            |
			| cz    | c/krystaly-oscilatory/oscilatory                                                                                | L1    | oscillator           |
			| uk    | c/switches-relays/switches/switch-components                                                                    | L2    | mswitchComponents    |
			| uk    | c/lighting-products/lamps-tubes/led-replacement-lamps                                                           | L2    | mledReplacementLamps |
			| fr    | c/semiconduttori-discreti/transistori/transistor-bipolari                                                       | L2    | transistorBipolar    |
			| uk    | c/cable-wire-cable-assemblies/cable-management/cable-wire-markers/clip-on-wire-markers-tie-on-wire-markers      | L3    | lscabma              |
			| uk    | c/cable-wire-cable-assemblies/cable-management/cable-wire-markers/heat-shrink-wire-markers                      | L3    | shrinkwire           |
			| de    | c/kabel-einzeladern-konfektionierte-kabel/kabelmanagement/kabelmarkierungen/warmeschrumpfbare-kabelmarkierungen | L3    | delecat              |
		@apac
		Examples:
			| store | categoryPage                                                                                                | Level | image                |
			| sg    | c/audio-visual                                                                                              | L0    | mob_audioVisual      |
			| au    | c/automation-process-control                                                                                | L0    | autoprocesscontrol   |
			| nz    | c/batteries-chargers                                                                                        | L0    | batt                 |
			| sg    | c/cable-wire-cable-assemblies                                                                               | L0    | cable-wire-a         |
			| cn    | c/optoelectronics-displays/displays                                                                         | L0    | displays             |
			| sg    | c/office-computer-networking-products/computer-products                                                     | L1    | computerProducts     |
			| cn    | c/optoelectronics-displays/led-products                                                                     | L1    | displaycn            |
			| hk    | c/semiconductors-discretes/diodes                                                                           | L1    | semdio               |
			| sg    | c/switches-relays/switches/switch-components                                                                | L2    | mswitchComponents    |
			| au    | c/lighting-products/lamps-tubes/led-replacement-lamps                                                       | L2    | mledReplacementLamps |
			| au    | /c/cable-wire-cable-assemblies/cable-management/cable-wire-markers/clip-on-wire-markers-tie-on-wire-markers | L3    | lscabma              |
			| sg    | c/cable-wire-cable-assemblies/cable-management/cable-wire-markers/heat-shrink-wire-markers                  | L3    | shrinkwire           |

		@nwk
		Examples:
			| store  | categoryPage                                                                                                  | Level | image              |
			| us     | c/automation-process-control                                                                                  | L0    | autoprocesscontrol |
			| canada | c/security-audio-visual                                                                                       | L0    | securityav         |
			| mexico | c/equipos-de-pruebas-medicion                                                                                 | L0    | equiprub           |
			| us     | c/optoelectronics-displays/displays                                                                           | L0    | displays           |
			| mexico | c/office-computer-networking-products/computer-products                                                       | L1    | computerProducts   |
			| us     | c/enclosures-racks-cabinets/enclosures-boxes-cases                                                            | L1    | cabinets           |
			| mexico | c/equipos-de-pruebas-medicion/conectores-para-pruebas-pinzas-para-probar-ci/conectores-tipo-banana            | L2    | displaycn          |
			| us     | c/semiconductors-discretes/transistors/bipolar-transistors                                                    | L2    | sembipolar         |
			| us     | c/cable-wire-cable-assemblies/cable-management/raceway-duct-fittings-installation-tools/raceway-duct-fittings | L3    | raceway            |
			| canada | c/cable-wire-cable-assemblies/cable-management/raceway-duct-fittings-installation-tools/raceway-duct          | L3    | racewayduct        |


	@pdp @Sprint72 @SRE115 @live
	Scenario Outline: Visual test for product details page in "<store>"
		Given user navigate to "<store>" store homepage and "does" accept the cookies
		When customer accesses the website as "guest" user
		And create folder structure for base & resultant images
		And I navigate to "pdp" page
		And I wait for "5" seconds
		Then customer visually compare "viewport" image with the baseline "<image>"
		Then customer visually compare "full" image with the baseline "<image>"
		But skip if baseline image captured
		@eu
		Examples:
			| store | image        | pdp                                                                 |
			| uk    | bkorder      | on-semiconductor/bav99/diode-dual-70v-200ma-sot-23/dp/9843612       |
			| uk    | instock      | samtec/tsm-103-01-l-sv/connector-header-3pos-1row-2-54mm/dp/2578716 |
			| uk    | nls          | multicomp/bas116/diode-high-speed-sot-23/dp/1621824                 |
			| uk    | 360-video    | 4d-systems/4dpi-24-hat/2-4-hat-display-for-raspberry/dp/2456984     |
			| nl-BE | be-backorder | amp-te-connectivity/1-770174-0/housing-vertical-4way/dp/1098526     |
			| ie    | ie-instock   | /werma/64110000/permanent-light-12-240v-red/dp/1215233              |
		@nwk
		Examples:
			| store  | image        | pdp                                                                               |
			| es-us  | es-backorder | diodes-inc/bav99t-7-f/diode-fast-switching-85v-0-15w/dp/23T4531                   |
			| us     | instock      | on-semiconductor/bav99lt1g/small-signal-diode-dual-series/dp/58M3990              |
			| canada | prd-images   | raspberry-pi/raspbrry-moda-512m/silicon-manufacturer-broadcom/dp/81Y5333          |
			| fr-CA  | video        | bud-industries/pnr-2607-dg/enclosure-wall-mount-abs-gray/dp/77C5306               |
			| en-MX  | 360img       | texas-instruments/cdcm6208v1evm/evaluation-board-frequency-synthesizer/dp/94T9790 |
		@apac
		Examples:
			| store | image   | pdp                                                                    |
			| sg    | nls     | multicomp/bas116/diode-high-speed-sot-23/dp/162182                     |
			| sg    | 360im   | 4d-systems/4dpi-24-hat/2-4-hat-display-for-raspberry/dp/2456984        |
			| au    | video   | amp-te-connectivity/206705-1/circular-connector-receptacle/dp/1056401  |
			| cn    | instock | /diodes-inc/bav99-7-f/diode-sw-dual-75v-0-35w-sot23/dp/1843683         |
			| cn    | bkorder | diodes-inc/bav170/diode-ss-dual-85v-0-125a-sot23/dp/1902412RL          |
			| en-TW | twistck | switchcraft-conxall/en3p2f16x/industrial-circular-rcpt-2pos/dp/2775712 |
			
	@pdp @sprint_85 @live @SSP-1752
	Scenario Outline: "<store>" - Visual testing in PDP for "<type>" product type
		Given user navigate to "<store>" store homepage and "does" accept the cookies
		When customer accesses the website as "guest" user
		And create folder structure for base & resultant images
		And set expected cutoff similarity as "75" percent and save baseline images property to "false"
		And I navigate to "<pdp>" page
		And I wait for "5" seconds
		Then I validate whether whole page matches visually with the expected "<image>" product page
#		Then customer visually compare "viewport" image with the baseline "<image>"
#		Then customer visually compare "full" image with the baseline "<image>"
		But skip if baseline image captured
		
		@eu
    Examples: 
      | store | pdp                                                                            | image                 | type                      |
      | uk    | neohm-te-connectivity/cpf0805b10ke1/res-thin-film-10k-0-1-0-1w-0805/dp/1697445 | IS_CutTape_uk         | Instock CutTape           |
      | uk    | rubycon/16zlj1000m10x16/cap-alu-elec-1000uf-16v-rad/dp/1831271                 | IS_UL_uk              | Instock Ultra Librarian   |
      | uk    | epcos/b82462a4104k/inductor-un-shielded-100uh-smd/dp/2367905                   | IS_Alt_uk             | Instock with Alternatives |
      | uk    | vishay/bfc237530153/cap-film-pp-15nf-1-6kv-rad/dp/1166102                      | ABO_uk                | Available for Back Order  |
      | uk    | vishay/crcw04027k50fked/res-thick-film-7k5-1-0-063w-0402/dp/1469729            | ABO_CutTape_UL_Alt_uk | mix                       |
      | uk    | bourns-jw-miller/pm5022-101m-rc/inductor-un-shielded-100uh-3-2a/dp/1835795     | ABO_FullReel_uk       | Full Reel                 |
      | uk    | united-chemi-con/esmh630vsn103mr50t/aluminum-electrolytic-capacitor/dp/1680969 | ABO_USStock_uk        | US Stock                  |
      | uk    | multicomp/mc0063w060315k1/resistor-5k1-0-063w-1-0603/dp/1127557                | NLS_uk                | No Longer Stocked         |
      | uk    | arm/mdk-pro-lc/sw-mdk-pro-license-download/dp/2341536                          | DigitalDelivery_uk    | Digital Delivery          |
      | uk    | keil/mdk-arm-es-t-lc/compiler-cortex-m-nl-1yr-download/dp/2493537              | SoftwareDownload_uk   | Software Download         |
      | at    | neohm-te-connectivity/cpf0805b10ke1/res-thin-film-10k-0-1-0-1w-0805/dp/1697445 | IS_CutTape_at         | Instock CutTape           |
      | nl-BE | rubycon/16zlj1000m10x16/cap-alu-elec-1000uf-16v-rad/dp/1831271                 | IS_UL_be              | Instock UltraLibrariyan   |
      | bg    | epcos/b82462a4104k/inductor-un-shielded-100uh-smd/dp/2367905                   | IS_Alt_bg             | Instock with Alternatives |
      | de-CH | vishay/bfc237530153/cap-film-pp-15nf-1-6kv-rad/dp/1166102                      | ABO_ch                | Available for Back Order  |
      | cz    | vishay/crcw04027k50fked/res-thick-film-7k5-1-0-063w-0402/dp/1469729            | ABO_CutTape_UL_Alt_cz | mix                       |
      | de    | bourns-jw-miller/pm5022-101m-rc/inductor-un-shielded-100uh-3-2a/dp/1835795     | ABO_FullReel_de       | Full Reel                 |
      | dk    | united-chemi-con/esmh630vsn103mr50t/aluminum-electrolytic-capacitor/dp/1680969 | ABO_USStock_dk        | US Stock                  |
      | ee    | multicomp/mc0063w060315k1/resistor-5k1-0-063w-1-0603/dp/1127557                | NLS_ee                | No Longer Stocked         |
      | es    | arm/mdk-pro-lc/sw-mdk-pro-license-download/dp/2341536                          | DigitalDelivery_es    | Digital Delivery          |
      | fr    | keil/mdk-arm-es-t-lc/compiler-cortex-m-nl-1yr-download/dp/2493537              | SoftwareDownload_fr   | Software Download         |

    @apac
    Examples: 
      | store | pdp                                                                | image               | type                                     |
      | au    | multicomp/mbrf20200c/schottky-diode-20a-200v-to-220/dp/1860293     | InStock_au          | In Stock                                 |
      | cn    | vishay/1n5222b-tr/zener-diode-500mw-2-5v-do-35/dp/1470564          | UL_CutTape_cn       | Instock UL and  CutTape                  |
      | hk    | infineon/bdp949/transistor-npn-sot-223/dp/1214295                  | NLM_hk              | No Longer Manufactured                   |
      | in    | diodes-inc/fcx1149ata/transistor-pnp-25v-3a-sot-89/dp/1902471      | NLS_in              | No Longer Stocked                        |
      | kr    | vishay/vs-t50ria40/thyristor-80a-400v-d-55/dp/1905222              | ABO_kr              | Available for Back Order                 |
      | my    | vishay/vbt3045c-e3-8w/schottky-rectifier-array-30a-to/dp/1904517   | CutTape_my          | Cut Tape                                 |
      | nz    | rohm/2sc5662t2lp/transistor-vmt3/dp/1680136RL                      | RR_nz               | Re Reel                                  |
      | ph    | on-semiconductor/mmbt2369/transistor-npn-0-2a-15v-sot23/dp/1700700 | UL_CutTape_ph       | Available for Back Order Cut Tape and UL |
      | sg    | on-semiconductor/mcr22-8g/scr-thyristor-1-5a-600v-to-92/dp/1277932 | NLM_sg              | No Longer Manufactured                   |
      | th    | arm/mdkes-kd-40000/mdk-cortex-m-flex-floating-download/dp/2409504  | DigitalDelivery_th  | Digital Delivery                         |
      | tw    | altium/11-100-15-1-e/circuitstudio-commercial-license/dp/2490980   | SoftwareDownload_tw | Software Download                        |
      | vn    | vishay/1n5222b-tr/zener-diode-500mw-2-5v-do-35/dp/1470564          | UL_CutTape_vn       | Instock UL and  CutTape                  |

    @nwk
    Examples: 
      | store  | pdp                                                                             | image              | type                                     |
      | us     | airpax/9904-111-31104/motor-220vac-250rpm-reversible/dp/18K8498                 | InStock_us         | In Stock                                 |
      | es-us  | legris/0902-10-13/pneumatic-fitting-straight-connector/dp/34M9428               | ABO_us             | Available for Back Order                 |
      | mexico | diodes-inc/dfls1200-7/schottky-diode-1a-200v-powerdi/dp/25R4482                 | CutTape_mx         | Cut Tape                                 |
      | pt-BR  | multicomp/sd38-0-1a/analogue-panel-meter-moving-coil/dp/14J8234                 | ABO_DirectShip_br  | Available for Back Order and Direct Ship |
      | canada | eaton/eu5e-swd-4dx/digital-module-24vdc-4ma/dp/17W5660                          | video_ca           | Product with Video                       |
      | us     | segger/15-23-00-ses-for-cortex-m/ide-ses-cortex-m-mcu-mpu/dp/50Y8929            | SoftwareDnld_us    | Software Download                        |
      | mexico | atollic/ts-arm-pro-win-dle-1u/truestudio-ide-usb-locked-arm/dp/29Y2622          | DigitalDelivery_mx | Digital Delivery                         |
      | fr-CA  | segger/9-55-04-emusb-hostprobundl-ssl/usb-host-stack-source-code-lic/dp/47Y7258 | SoftwareDnld_ca    | Software Download                        |
      | pt-BR  | multicomp/1n4733a/zener-diode-1w-5-1v-do-41/dp/90R9420                          | CutTape_br         | Cut Tape                                 |
      | us     | diodes-inc/dfls1200-7/schottky-diode-1a-200v-powerdi/dp/25R4482                 | Instock_us         | In Stock                                 |
      | canada | on-semiconductor/mb6s/diode-full-reel/dp/67R2096                                | FullReel_ca        | Full Reel                                |
      | mexico | newport-electronics/6130a/universal-panel/dp/10R6741                            | NLS_mx             | No Longer Stocked                        |
