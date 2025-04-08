import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { Stack } from 'expo-router'
import style from '@/constants/style'
import MainTemplate from '@/components/mainApp/MainTemplate'

const MainLayout = () => {
  return (
    <MainTemplate>
      <Stack>
          <Stack.Screen
            name='main'
            options={{
              headerShown: false
            }}
          />
      </Stack>
    </MainTemplate>
  )
}

export default MainLayout

const styles = StyleSheet.create({

})