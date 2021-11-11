package si.kflabs.mojpanj.data.domain.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector

data class EducationCategory(
    val id: Int,
    val title: String
) {
    val icon: ImageVector
    get() {
        return when(id) {
            1 -> Icons.Default.Inventory2
            2 -> Icons.Default.HealthAndSafety
            3 -> Icons.Default.LocalFlorist
            4 -> Icons.Default.EmojiNature
            else -> Icons.Default.Book
        }
    }
}