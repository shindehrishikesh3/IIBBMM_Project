#Author: Soumen Maity
@web @visual
Feature: Visual validation on different pages

  @category @Sprint71 @SSP1233 @L0 @live
  Scenario Outline: Visual test for L0 category Node page in "<store>"
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    When customer accesses the website as "guest" user
    And create folder structure for base & resultant images
    #And set expected cutoff similarity as "75" percent and save baseline images property to "false"
    And I navigate to "<categoryPage>" page
    And I wait for "5" seconds
    Then I validate whether whole page matches visually with the expected "<image>"
    Then customer visually compare "viewport" image with the baseline "<image>"
    Then customer visually compare "full" image with the baseline "<image>"
    But skip if baseline image captured

    @eu
    Examples: 
      | store | categoryPage                                     | image                       |
      | uk    | c/audio-visual                                   | audioVisual                 |
      | uk    | c/automation-process-control                     | autoprocesscontrol          |
      | uk    | c/batteries-chargers                             | batt                        |
      | uk    | c/cable-wire-cable-assemblies                    | cable-wire-a                |
      | uk    | c/chemicals-adhesives                            | chemical-adh                |
      | uk    | c/circuit-protection                             | circuit-pro                 |
      | uk    | c/cooling-thermal-management                     | coolther                    |
      | uk    | c/connectors                                     | conn                        |
      | uk    | c/crystals-oscillators                           | crystal-osc                 |
      | uk    | c/development-boards-evaluation-tools            | dev-ev-tools                |
      | uk    | c/electrical                                     | electrical                  |
      | uk    | c/embedded-computers-education-maker-boards      | embed-cemb                  |
      | uk    | c/enclosures-racks-cabinets                      | erc                         |
      | uk    | c/engineering-software                           | engg-soft                   |
      | uk    | c/fasteners-mechanical                           | fast-mech                   |
      | uk    | c/led-lighting-components                        | led-light                   |
      | uk    | c/lighting-products                              | light-prod                  |
      | uk    | c/office-computer-networking-products            | ocnetwork                   |
      | uk    | c/optoelectronics-displays                       | opto-dis                    |
      | uk    | c/passive-components                             | passivec                    |
      | uk    | c/power-line-protection                          | powlinep                    |
      | uk    | c/security                                       | sec                         |
      | uk    | c/semiconductors-discretes                       | semi                        |
      | uk    | c/semiconductors-ics                             | semi-ics                    |
      | uk    | c/sensors-transducers                            | sensor-transd               |
      | uk    | c/static-control-site-safety-clean-room-products | scscrp                      |
      | uk    | c/switches-relays                                | switch-re                   |
      | uk    | c/test-measurement                               | test-man                    |
      | uk    | c/tools-production-supplies                      | tool-prod                   |
      | uk    | c/transformers                                   | transf                      |
      | uk    | c/wireless-modules-adaptors                      | wireless-modules            |
      | fr    | c/automatismes-controle-de-process               | Automation                  |
      | es    | c/cables-conjuntos-de-cables                     | cables                      |
      | it    | c/componenti-elettrici                           | ElectricComponents          |
      | pl    | c/elementy-mocujace-i-mechaniczne                | EmbeddedComputersMakerBoard |
      | hu    | c/enclosures-racks-cabinets                      | EnclosuresRacksCabinets     |
      | ie    | c/engineering-software                           | EngineeringSoftware         |
      | cz    | c/krystaly-oscilatory                            | CrystalOscillator           |
      | dk    | c/fasteners-mechanical                           | FastnerMechanical           |

    @apac
    Examples: 
      | store | categoryPage                          | image            |
      | sg    | c/enclosures-racks-cabinets           | erc              |
      | sg    | c/engineering-software                | engg-soft        |
      | sg    | c/fasteners-mechanical                | fast-mech        |
      | sg    | c/led-lighting-components             | led-light        |
      | sg    | c/lighting-products                   | light-prod       |
      | sg    | c/office-computer-networking-products | ocnetwork        |
      | sg    | c/optoelectronics-displays            | opto-dis         |
      | sg    | c/passive-components                  | passivec         |
      | sg    | c/power-line-protection               | powlinep         |
      | sg    | c/security                            | sec              |
      | sg    | c/semiconductors-discretes            | semi             |
      | sg    | c/semiconductors-ics                  | semi-ics         |
      | sg    | c/sensors-transducers                 | sensor-transd    |
      | au    | c/led-lighting-components             | ledLightning     |
      | cn    | c/lighting-products                   | lightingProducts |
      | hk    | c/led-lighting-components             | Interfaces       |
      | kr    | c/optoelectronics-displays            | Optoelectronics  |
      | my    | c/power-line-protection               | powerLine        |
      | ph    | c/semiconductors-discretes            | Semiconductor    |

    @nwk
    Examples: 
      | store  | categoryPage                                     | image            |
      | us     | c/chemicals-adhesives                            | chemical-adh     |
      | us     | c/circuit-protection                             | circuit-pro      |
      | us     | c/connectors                                     | conn             |
      | us     | c/crystals-oscillators                           | crystal-osc      |
      | us     | c/development-boards-evaluation-tools            | dev-ev-tools     |
      | us     | c/electrical                                     | electrical       |
      | us     | c/embedded-computers-education-maker-boards      | embed-cemb       |
      | us     | c/static-control-site-safety-clean-room-products | scscrp           |
      | us     | c/switches-relays                                | switch-re        |
      | us     | c/test-measurement                               | test-man         |
      | us     | c/tools-production-supplies                      | tool-prod        |
      | us     | c/transformers                                   | transf           |
      | us     | c/wireless-modules-adaptors                      | wireless-modules |
      | us     | c/wireless-modules-adaptors                      | WirelessModules  |
      | canada | c/connectors                                     | connectors       |
      | mexico | c/cables-alambres-ensambles-de-cables            | Cable            |

  @category @Sprint71 @SSP1233 @L1 @live
  Scenario Outline: Visual test for L1 category Node page in "<store>"
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    When customer accesses the website as "guest" user
    And create folder structure for base & resultant images
    #And set expected cutoff similarity as "75" percent and save baseline images property to "false"
    And I navigate to "<categoryPage>" page
    And I wait for "5" seconds
    #Then I validate whether whole page matches visually with the expected "<image>"
    Then customer visually compare "viewport" image with the baseline "<image>"
    Then customer visually compare "full" image with the baseline "<image>"
    But skip if baseline image captured

    @eu
    Examples: 
      | store | categoryPage                                                           | image            |
      | uk    | c/audio-visual/pro-audio                                               | proAudio         |
      | uk    | c/automation-process-control/automation-signaling                      | autoSignaling    |
      | uk    | c/cable-wire-cable-assemblies/cable-assemblies                         | cableAssemblies  |
      | uk    | c/chemicals-adhesives/adhesives-glues                                  | glues            |
      | uk    | c/circuit-protection/circuit-breakers                                  | circuitBreakers  |
      | uk    | c/connectors/audio-video-connectors-adapters                           | connectors       |
      | uk    | c/cooling-thermal-management/fans-blowers                              | fans             |
      | uk    | c/crystals-oscillators/oscillators                                     | oscillators      |
      | uk    | c/development-boards-evaluation-tools/data-conversion-development-kits | devBoards        |
      | uk    | c/embedded-computers-education-maker-boards/arm                        | arm              |
      | uk    | c/enclosures-racks-cabinets/enclosure-rack-cabinet-accessories         | accessories      |
      | uk    | c/fasteners-mechanical/fasteners-fixings                               | fasteners        |
      | uk    | c/led-lighting-components/led-driver-ics                               | led              |
      | uk    | c/lighting-products/lamps-tubes                                        | lamps            |
      | uk    | c/office-computer-networking-products/computer-products                | computerProducts |
      | uk    | c/optoelectronics-displays/displays                                    | displays         |
      | uk    | c/passive-components/capacitors                                        | capacitors       |
      | uk    | c/power-line-protection/power-supplies                                 | powerSupplies    |
      | uk    | c/semiconductors-discretes/diodes                                      | diodes           |
      | uk    | c/semiconductors-ics/amplifiers-comparators                            | amplifiers       |
      | uk    | c/sensors-transducers/sensors                                          | sensors          |
      | fr    | c/automatismes-controle-de-process/affichages-panneau-instrumentation  | API              |
      | es    | c/cables-conjuntos-de-cables/gestion-de-cables                         | Cables           |
      | it    | c/automazione-e-controllo-dei-processi/segnalatori-automazione         | Automation       |
      | pl    | c/elementy-mocujace-i-mechaniczne/elementy-mocujace-i-laczace          | element          |
      | hu    | c/enclosures-racks-cabinets/enclosures-boxes-cases                     | enclosures       |
      | ie    | c/engineering-software/compilers-ides                                  | compilers        |
      | cz    | c/krystaly-oscilatory/oscilatory                                       | oscillator       |
      | dk    | c/fasteners-mechanical/knobs-accessories                               | knobs            |

    @apac
    Examples: 
      | store | categoryPage                                                | image      |
      | au    | c/led-lighting-components/high-brightness-leds              | leds       |
      | au    | c/automation-process-control/panel-displays-instrumentation | panel      |
      | au    | c/cable-wire-cable-assemblies/cable-management              | cable      |
      | au    | c/circuit-protection/circuit-breakers                       | circuit    |
      | au    | c/circuit-protection/tvs-transient-voltage-suppressors      | tvs        |
      | au    | c/connectors/circular-connectors-components                 | connectors |
      | au    | c/cooling-thermal-management/thermal-interface-materials    | thermal    |
      | au    | c/electrical/spare-repair-parts                             | electrical |
      | cn    | c/lighting-products/lamps-tubes                             | lamps      |
      | hk    | c/led-lighting-components/led-driver-ics                    | led        |
      | kr    | c/optoelectronics-displays/displays                         | displays   |
      | my    | c/power-line-protection/power-supplies                      | power      |
      | ph    | c/semiconductors-discretes/thyristors                       | thyristors |

    @nwk
    Examples: 
      | store  | categoryPage                                                            | image          |
      | us     | c/wireless-modules-adaptors/communications-networking-modules           | communications |
      | us     | c/automation-process-control/process-controllers-programmers-indicators | automation     |
      | us     | c/cable-wire-cable-assemblies/multicore-cable                           | multicore      |
      | us     | c/circuit-protection/fuses-fuse-accessories                             | fuses          |
      | us     | c/connectors/connector-tools-accessories                                | connectors     |
      | us     | c/embedded-computers-education-maker-boards/other-embedded-computers    | embedded       |
      | us     | c/led-lighting-components/led-driver-ics                                | led            |
      | us     | c/optoelectronics-displays/optocouplers                                 | optocouplers   |
      | us     | c/passive-components/emc-rfi-suppression                                | emc            |
      | us     | c/test-measurement/test-leads-test-probes                               | test           |
      | canada | c/connectors/circular-connectors-components                             | connectors     |
      | mexico | c/cables-alambres-ensambles-de-cables/organizacion-de-cables            | Cable          |

  #Author: Sandhya Seelam
  @category @Sprint71 @SSP1233 @L2 @live
  Scenario Outline: Visual test for L2 category Node page in "<store>"
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
      | store | categoryPage                                                                              | image                        |
      | uk    | c/passive-components/emc-rfi-suppression/suppression-filters                              | suppressionFilters           |
      | uk    | c/passive-components/emc-rfi-suppression/ferrites-ferrite-assortments                     | ferriteAssortments           |
      | uk    | c/automation-process-control/panel-displays-instrumentation                               | panelDisplaysInstrumentation |
      | uk    | c/automation-process-control/industrial-switches-control-stations/anti-vandal-switches    | antiVadalSwitches            |
      | uk    | c/semiconductors-discretes/diodes/schottky-diodes                                         | schottkyDiodes               |
      | uk    | c/power-line-protection/power-supplies/dc-dc-converters                                   | dcDcConverters               |
      | uk    | c/power-line-protection/power-supplies/ac-dc-converters                                   | acDcConverters               |
      | uk    | c/switches-relays/switches/switch-components                                              | switchComponents             |
      | uk    | c/lighting-products/lamps-tubes/led-replacement-lamps                                     | ledReplacementLamps          |
      | de    | c/passive-bauelemente/induktivitaten-drosseln-spulen/leistungsinduktivitaten              | inductive                    |
      | it    | c/elementi-di-fissaggio-e-meccanici/elementi-di-attacco-fissaggio/distanziatori-e-piedini | spacersFeet                  |
      | fr    | c/semiconduttori-discreti/transistori/transistor-bipolari                                 | transistorBipolar            |

    @apac
    Examples: 
      | store | categoryPage                                                          | image                       |
      | sg    | c/semiconductors-discretes/diodes/schottky-diodes                     | schottkyDiodes              |
      | sg    | c/semiconductors-ics/power-management-ics-pmic/dc-dc-power-management | dcDcPowerManagement         |
      | sg    | c/switches-relays/switches/switch-components                          | switchComponents            |
      | sg    | c/switches-relays/relays/solid-state-relays-contactors                | solidStateRelaysContractors |
      | sg    | c/fasteners-mechanical/fasteners-fixings/spacers-feet                 | spacersFeet                 |
      | sg    | c/sensors-transducers/sensors/pressure-sensors-transducers            | transducers                 |
      | cn    | c/passive-components/capacitors/ceramic-capacitors                    | ceramicCapacitors           |
      | cn    | c/passive-components/capacitors/polymer-capacitors                    | polymerCapacitors           |
      | au    | c/semiconductors-discretes/transistors/bipolar-transistors            | bipolarTransistors          |

    @nwk
    Examples: 
      | store  | categoryPage                                                                                      | image                  |
      | us     | c/power-line-protection/power-supplies/dc-dc-converters                                           | dcDcconverters         |
      | us     | c/automation-process-control/panel-displays-instrumentation/panel-instrumentation                 | panelInstrumentation   |
      | us     | c/semiconductors-ics/power-management-ics-pmic/voltage-regulators                                 | voltageRegulators      |
      | us     | c/circuit-protection/fuses-fuse-accessories/fuses                                                 | circuitProtectionFuses |
      | us     | c/static-control-site-safety-clean-room-products/site-safety/labels-stencils                      | labelsStencils         |
      | canada | c/passive-components/inductors/power-inductors                                                    | powerInductors         |
      | mexico | c/relevadores-e-interruptores-switch-/interruptores-switch-/componentes-para-interruptores-switch | switchInterrupters     |

  @pdp @sprint_85 @live @SSP-1752
  Scenario Outline: "<store>" - Visual testing in PDP for "<type>" product type
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    When customer accesses the website as "guest" user
    And create folder structure for base & resultant images
    And set expected cutoff similarity as "75" percent and save baseline images property to "false"
    And I navigate to "<pdp>" page
    And I wait for "5" seconds
    Then I validate whether whole page matches visually with the expected "<image>" product page
    #Then customer visually compare "viewport" image with the baseline "<image>"
    #Then customer visually compare "full" image with the baseline "<image>"
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
