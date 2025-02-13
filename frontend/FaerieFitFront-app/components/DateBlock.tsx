import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import Calendar from './SVG/Calendar'
import Zametki from './SVG/Zametki'
import Cloaks from './SVG/Cloaks'

const DateBlock = () => {
  return (
    <View style={{
      flexDirection: 'row',
      padding: 10,
      gap: 10
    }}>
      <View style={styles.firstV}>
        <View>
          <View>
  
          </View>
          <View>
            {/* <Calendar/>
            <Cloaks/>
            <Zametki/> */}
          </View>
        </View>
      </View>
      <View style={styles.firstV}>
        <View>
          <View>
  
          </View>
          <View>
            
          </View>
        </View>
      </View>
    </View>
  )
}

export default DateBlock

const styles = StyleSheet.create({
  firstV:{
    maxWidth: 250,
    height: 182,
    flexGrow: 1,
    backgroundColor: '#4CAC44'
  },
  secondV:{

  },
  thirdV:{

  },
})