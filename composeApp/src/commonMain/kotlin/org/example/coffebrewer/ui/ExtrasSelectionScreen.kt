package org.example.coffebrewer.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coffebrewer.composeapp.generated.resources.Res
import coffebrewer.composeapp.generated.resources.topping_icon
import org.example.coffebrewer.usecase.CoffeeExtras
import org.jetbrains.compose.resources.painterResource

@Composable
fun ExtrasSelectionScreen(
    onExtrasSelected: (List<CoffeeExtras>) -> Unit = {},
    extrasViewModel: ExtrasViewModel,
) {

    val state = extrasViewModel.mutableStateFlow
    var showFinalAlert by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Please select Your extras",
            fontSize = 24.sp
        )

        Image(
            modifier = Modifier.size(100.dp, 100.dp),
            painter = painterResource(Res.drawable.topping_icon),
            contentDescription = null
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text("Milk")
            RadioButton(
                selected = state[CoffeeExtras.Milk] == true,
                onClick = {
                    extrasViewModel.addExtra(CoffeeExtras.Milk)
                }
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text("Chocolate")
            RadioButton(
                selected = state[CoffeeExtras.Chocolate] == true,
                onClick = {
                    extrasViewModel.addExtra(CoffeeExtras.Chocolate)
                }
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text("Cinnamon")
            RadioButton(
                selected = state[CoffeeExtras.Cinnamon] == true,
                onClick = {
                    extrasViewModel.addExtra(CoffeeExtras.Cinnamon)
                }
            )
        }

        Button(
            content = {
                Text("BREW !!!!!")
            },
            onClick = {
                showFinalAlert = true
//                onExtrasSelected(listOf())
            }
        )
    }

    if (showFinalAlert) {
        AlertDialog(
            onDismissRequest = {
                showFinalAlert = false
            },
            title = {
                Text("This is the final step")
            },
            text = {
                Text("Now we are going to brew your coffee")
            },
            confirmButton = {
                Button(
                    onClick = {
                        showFinalAlert = false
                    },
                    content = {
                        Text("Yes Brew")
                    }
                )
            },
            dismissButton = {
                Button(
                    onClick = {
                        showFinalAlert = false
                    },
                    content = {

                        Text("Not yet")
                    }
                )
            }
        )
    }
}

class ExtrasViewModel {

    var mutableStateFlow = SnapshotStateMap<CoffeeExtras, Boolean>()

    init {
        mutableStateFlow.put(CoffeeExtras.Cinnamon, false)
        mutableStateFlow.put(CoffeeExtras.Chocolate, false)
        mutableStateFlow.put(CoffeeExtras.Milk, false)
    }

    fun addExtra(extra: CoffeeExtras) {
        mutableStateFlow[extra]?.let {
            mutableStateFlow[extra] = !it
        } ?: {
            mutableStateFlow[extra] = true
        }
    }
}